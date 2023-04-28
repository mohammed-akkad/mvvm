package com.example.mvvm.model.network

class FakeApi {
    private val listOfString = listOf(
        "user-ar",
        "user-en",
        "user-ru",
        "user-ch"
    )
     fun getNameUser(): String{
       return listOfString.random()
    }
}