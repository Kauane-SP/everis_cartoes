package com.example.cartoeseveris.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class CartoesModel(
    @SerializedName("number") val numberCartoes: String,
    @SerializedName("data") val dataVencimento: String
)