package com.example.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.network.FakeApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel: ViewModel() {
    private val fakeApi = FakeApi()
    private val _currentUser = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()
    val currentUser: LiveData<String>
        get() = _currentUser

    fun getUserName(){
        fakeApi.getNameUser()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::getUserNameSuccess).add(compositeDisposable)
    }
    private fun getUserNameSuccess(name: String){
        _currentUser.postValue(name)

    }
    private fun Disposable.add(compositeDisposable: CompositeDisposable){
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}