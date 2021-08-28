package com.example.cartoeseveris.useCase

import com.example.cartoeseveris.model.CardModel
import com.example.cartoeseveris.repository.CallbackImplementation
import com.example.cartoeseveris.repository.CardRepository

class CardUseCase(private val repository: CardRepository) : CallbackImplementation {

    override suspend fun requestCards(
        callbackSuccess: (successes: List<CardModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        repository.requestCards(callbackSuccess, callbackError)
    }

}