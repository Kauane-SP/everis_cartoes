package com.example.cartoeseveris.api.cartoesApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CartoesApiTask {

    private fun getUrlProvider(): Retrofit = Retrofit.Builder()
        .baseUrl("https://610aee6952d56400176b0079.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun cartoesApi(): CartoesApi = getUrlProvider().create()
}