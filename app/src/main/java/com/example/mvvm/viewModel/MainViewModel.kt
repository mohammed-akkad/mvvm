package com.example.mvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.network.FakeApi

class MainViewModel: ViewModel() {
    private val fakeApi = FakeApi()
    private val _currentUser = MutableLiveData<String>()
    val currentUser: LiveData<String>
        get() = _currentUser

    init {
        getUserName()
    }

    fun getUserName(){
        _currentUser.postValue(fakeApi.getNameUser())
    }
}