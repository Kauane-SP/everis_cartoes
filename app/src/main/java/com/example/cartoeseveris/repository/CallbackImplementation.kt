package com.example.cartoeseveris.repository

import com.example.cartoeseveris.model.CardModel

interface CallbackImplementation {

    suspend fun requestCards(
        callbackSuccess: (success: List<CardModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    )
}