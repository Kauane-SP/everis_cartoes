package com.example.cartoeseveris.repository

import com.example.cartoeseveris.model.CartoesModel

interface CallbackImplementation {

    suspend fun requestCartoes(
        callbackSuccess: (success: List<CartoesModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    )
}