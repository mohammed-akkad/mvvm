package com.example.mvvm.model.network

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class FakeApi {
    private val listOfString = listOf(
        "user-ar",
        "user-en",
        "user-ru",
        "user-ch"
    )
     @SuppressLint("SuspiciousIndentation")
     fun getNameUser(): Single<String>{
       val username =  listOfString.random()
         return Single.just(username).delay(5,TimeUnit.SECONDS)
    }
}