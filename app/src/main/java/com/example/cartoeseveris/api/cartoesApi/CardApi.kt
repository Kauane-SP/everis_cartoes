package com.example.cartoeseveris.api.cartoesApi

import com.example.cartoeseveris.model.CardModel
import retrofit2.Call
import retrofit2.http.GET

interface CardApi {

    @GET("cartoes")
    fun getCartoesApi(
    ): Call<List<CardModel>>
}