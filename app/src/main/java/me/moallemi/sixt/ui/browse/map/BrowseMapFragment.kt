package me.moallemi.sixt.ui.browse.map

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_browse_map.*
import me.moallemi.sixt.R
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.extension.createViewModel
import me.moallemi.sixt.extension.observe
import me.moallemi.sixt.model.Resource
import me.moallemi.sixt.model.ResourceState
import me.moallemi.sixt.ui.base.BaseFragment
import me.moallemi.sixt.ui.browse.list.BrowseViewModel
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

class BrowseMapFragment : BaseFragment() {

    private lateinit var viewModel: BrowseViewModel
    private var locationPermissionGranted = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse_map, container, false)
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(savedInstanceState)

        initMap()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        checkPermissions(REQUEST_LOCATION_FOR_INIT_MAP)

        viewModel = createViewModel(viewModelFactory) {
            observe(cars, ::handleStates)
        }
        viewModel.load()
    }

    @AfterPermissionGranted(REQUEST_LOCATION_FOR_INIT_MAP)
    @SuppressLint("MissingPermission")
    private fun initMap() {
        mapView.onResume()
        try {
            MapsInitializer.initialize(requireContext())
        } catch (_: Exception) {
        }

        mapView.getMapAsync { googleMap ->
            googleMap.uiSettings.isMyLocationButtonEnabled = false

            val munich = LatLng(48.1351, 11.5820)
            val cameraPosition = CameraPosition.Builder().target(munich).zoom(15f).build()
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }

    private fun handleStates(resource: Resource<List<Car>>?) {
        resource?.let {
            when (resource.resourceState) {
                ResourceState.LOADING -> handleLoading()
                ResourceState.SUCCESS -> handleSuccess(resource.data!!)
                ResourceState.ERROR -> handleError(resource.failure!!)
            }
        }
    }

    private fun handleLoading() {
        showLoading()
        hideErrorView()
        hideEmptyView()
    }

    private fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    private fun hideErrorView() {
        errorView.visibility = View.GONE
    }

    private fun hideEmptyView() {
        emptyView.visibility = View.GONE
    }

    private fun handleSuccess(data: List<Car>) {
        hideLoading()
        hideErrorView()
        hideEmptyView()
        showData(data)
    }

    private fun hideLoading() {
        loading.visibility = View.GONE
    }

    private fun showData(data: List<Car>) {
        if (data.isEmpty()) {
            hideErrorView()
            showEmptyView()
        } else {
            initMarkers(data)
        }
    }

    private fun initMarkers(data: List<Car>) {
        val latLngBoundsBuilder = LatLngBounds.builder()
        mapView.getMapAsync { googleMap ->
            data.filter { car -> car.latitude != null && car.longitude != null }
                .forEach { car ->
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(car.latitude!!, car.longitude!!))
                            .title(car.modelName)
                            .icon(BitmapDescriptorFactory.defaultMarker())
                    )
                    latLngBoundsBuilder.include(LatLng(car.latitude!!, car.longitude!!))
                }
            val latLngBounds = latLngBoundsBuilder.build()
            googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 100))
        }
    }

    private fun handleError(failure: Throwable) {
        hideLoading()
        hideEmptyView()
        showErrorView()
        // TODO showSnackBar(failure.message)
    }

    private fun showEmptyView() {
        emptyView.visibility = View.VISIBLE
    }

    private fun showErrorView() {
        errorView.visibility = View.VISIBLE
    }

    private fun checkPermissions(requestCodeFor: Int) {
        val perms = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        if (EasyPermissions.hasPermissions(requireContext(), *perms)) {
            locationPermissionGranted = true
        } else {
            locationPermissionGranted = false
            EasyPermissions.requestPermissions(
                PermissionRequest.Builder(this, requestCodeFor, *perms)
                    .setRationale(R.string.location_rationale)
                    .setPositiveButtonText(R.string.ok)
                    .setNegativeButtonText(R.string.cancel)
                    .build()
            )
        }
    }

    override fun onPermissionsGranted(requestCode: Int, list: List<String>) {
        super.onPermissionsGranted(requestCode, list)

        locationPermissionGranted = true
    }

    companion object {
        private const val REQUEST_LOCATION_FOR_INIT_MAP = 162
        fun getInstance() = BrowseMapFragment()
    }
}
