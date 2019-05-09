package me.moallemi.carexplorer.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.moallemi.carexplorer.data.datasource.CarRemoteDataSource
import me.moallemi.carexplorer.data.repository.CarRepositoryImpl
import me.moallemi.carexplorer.di.annotation.ViewModelKey
import me.moallemi.carexplorer.domain.repository.CarRepository
import me.moallemi.carexplorer.remote.datasource.CarRemoteDataSourceImpl
import me.moallemi.carexplorer.ui.browse.list.BrowseListFragment
import me.moallemi.carexplorer.ui.browse.list.BrowseViewModel
import me.moallemi.carexplorer.ui.browse.map.BrowseMapFragment

@Module
abstract class BrowseModule {

    @ContributesAndroidInjector
    internal abstract fun browseListFragment(): BrowseListFragment

    @ContributesAndroidInjector
    internal abstract fun browseMapFragment(): BrowseMapFragment

    @Binds
    @IntoMap
    @ViewModelKey(BrowseViewModel::class)
    abstract fun bindBrowseListViewModel(browseViewModel: BrowseViewModel): ViewModel

    @Binds
    abstract fun bindCarRepository(carRepositoryImpl: CarRepositoryImpl): CarRepository

    @Binds
    abstract fun bindCarRemoteDataSource(carRemoteDataSourceImpl: CarRemoteDataSourceImpl): CarRemoteDataSource
}