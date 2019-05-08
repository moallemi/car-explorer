package me.moallemi.sixt.ui.browse.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_browse_list.*
import me.moallemi.sixt.R
import me.moallemi.sixt.domain.model.Car
import me.moallemi.sixt.extension.createViewModel
import me.moallemi.sixt.extension.observe
import me.moallemi.sixt.model.Resource
import me.moallemi.sixt.model.ResourceState
import me.moallemi.sixt.ui.base.BaseFragment

class BrowseListFragment : BaseFragment() {

    private lateinit var viewModel: BrowseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse_list, container, false)
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
            with(recyclerView) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = CarListAdapter(data)
            }
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

    companion object {
        fun getInstance() = BrowseListFragment()
    }
}
