package me.moallemi.sixt.ui.browse.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import me.moallemi.sixt.R
import me.moallemi.sixt.extension.createViewModel
import me.moallemi.sixt.ui.base.BaseFragment

class BrowseListFragment : BaseFragment() {

    private lateinit var viewModel: BrowseListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_browse, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = createViewModel(viewModelFactory) {
            cars.observe(this@BrowseListFragment, Observer {
                println(it)
            })
        }
        viewModel.load()
    }

    companion object {
        fun getInstance() = BrowseListFragment()
    }
}
