package com.example.mvvm.model.network

class FakeApi {
    val listOfString = listOf(
        "mohammed",
        "ahmed",
        "ayman",
        "mahmoud"
    )
     fun getNameUser(): String{
       return listOfString.random()
    }
}