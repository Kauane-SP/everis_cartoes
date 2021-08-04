package com.example.cartoeseveris.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CartoesModel(
    @SerializedName("name") val name: String
)