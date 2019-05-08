package me.moallemi.sixt.ui.base

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment(), EasyPermissions.PermissionCallbacks,
    EasyPermissions.RationaleCallbacks {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, list: List<String>) {
    }

    override fun onPermissionsDenied(requestCode: Int, list: List<String>) {
    }

    override fun onRationaleAccepted(requestCode: Int) {
    }

    override fun onRationaleDenied(requestCode: Int) {
    }
}