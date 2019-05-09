package me.moallemi.carexplorer.ui.browse.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import me.moallemi.carexplorer.model.Resource
import me.moallemi.carexplorer.model.ResourceState
import me.moallemi.carexplorer.domain.interactor.GetCarsUseCase
import me.moallemi.carexplorer.domain.model.Car
import me.moallemi.carexplorer.ui.base.BaseViewModel
import javax.inject.Inject

class BrowseViewModel @Inject constructor(private val getCarsUseCase: GetCarsUseCase) : BaseViewModel() {

    private val _cars = MutableLiveData<Resource<List<Car>>>()
    val cars: LiveData<Resource<List<Car>>> = _cars

    init {
        useCases += getCarsUseCase
    }

    fun load() {
        _cars.value = Resource(ResourceState.LOADING)
        getCarsUseCase.execute(GetCarsUseCase.None(), ::success, ::error)
    }

    private fun success(carsList: List<Car>) {
        _cars.value = Resource(ResourceState.SUCCESS, carsList)
    }

    private fun error(throwable: Throwable) {
        _cars.value = Resource(ResourceState.ERROR, failure = throwable)
    }
}