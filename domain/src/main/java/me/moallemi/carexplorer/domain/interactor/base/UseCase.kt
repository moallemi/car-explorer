package me.moallemi.carexplorer.domain.interactor.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class UseCase {
    private var disposables: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}