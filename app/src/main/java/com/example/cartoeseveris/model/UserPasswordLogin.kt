package com.example.cartoeseveris.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserPasswordLogin(
    val register: String,
    val email: String
)