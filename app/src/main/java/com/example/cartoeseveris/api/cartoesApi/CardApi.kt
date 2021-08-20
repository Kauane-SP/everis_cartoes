package com.example.cartoeseveris.api.cartoesApi

import com.example.cartoeseveris.model.CartoesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoesApi {

    @GET("cartoes")
    fun getCartoesApi(
    ): Call<List<CartoesModel>>
}