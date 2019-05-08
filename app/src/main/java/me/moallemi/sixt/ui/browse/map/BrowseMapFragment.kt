package me.moallemi.sixt.ui.browse.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_browse_map.*
import me.moallemi.sixt.R
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.extension.createViewModel
import me.moallemi.sixt.extension.observe
import me.moallemi.sixt.model.Resource
import me.moallemi.sixt.model.ResourceState
import me.moallemi.sixt.ui.base.BaseFragment

class BrowseMapFragment : BaseFragment() {

    private lateinit var viewModel: BrowseMapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse_map, container, false)
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        try {
            MapsInitializer.initialize(requireContext())
        } catch (_: Exception) {
        }

        mapView.getMapAsync { googleMap ->
            googleMap.isMyLocationEnabled = true

            val sydney = LatLng(48.1351, 11.5820)
            val cameraPosition = CameraPosition.Builder().target(sydney).zoom(15f).build()
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
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

        viewModel = createViewModel(viewModelFactory) {
            observe(cars, ::handleStates)
        }
        viewModel.load()
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
// TODO
        }
    }

    private fun handleError(failure: Throwable) {
        hideLoading()
        hideEmptyView()
        showErrorView()
        // showSnackBar(failure.message)
    }

    private fun showEmptyView() {
        emptyView.visibility = View.VISIBLE
    }

    private fun showErrorView() {
        errorView.visibility = View.VISIBLE
    }

    companion object {
        fun getInstance() = BrowseMapFragment()
    }
}
