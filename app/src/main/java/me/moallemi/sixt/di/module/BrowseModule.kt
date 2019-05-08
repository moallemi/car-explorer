package me.moallemi.sixt.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.moallemi.sixt.data.datasource.CarRemoteDataSource
import me.moallemi.sixt.data.repository.CarRepositoryImpl
import me.moallemi.sixt.di.annotation.ViewModelKey
import me.moallemi.sixt.domain.repository.CarRepository
import me.moallemi.sixt.remote.datasource.CarRemoteDataSourceImpl
import me.moallemi.sixt.ui.browse.list.BrowseListFragment
import me.moallemi.sixt.ui.browse.list.BrowseListViewModel
import me.moallemi.sixt.ui.browse.map.BrowseMapFragment
import me.moallemi.sixt.ui.browse.map.BrowseMapViewModel

@Module
abstract class BrowseModule {

    @ContributesAndroidInjector
    internal abstract fun browseListFragment(): BrowseListFragment

    @ContributesAndroidInjector
    internal abstract fun browseMapFragment(): BrowseMapFragment

    @Binds
    @IntoMap
    @ViewModelKey(BrowseListViewModel::class)
    abstract fun bindBrowseListViewModel(browseListViewModel: BrowseListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BrowseMapViewModel::class)
    abstract fun bindBrowseMapViewModel(browseMapViewModel: BrowseMapViewModel): ViewModel

    @Binds
    abstract fun bindCarRepository(carRepositoryImpl: CarRepositoryImpl): CarRepository

    @Binds
    abstract fun bindCarRemoteDataSource(carRemoteDataSourceImpl: CarRemoteDataSourceImpl): CarRemoteDataSource
}