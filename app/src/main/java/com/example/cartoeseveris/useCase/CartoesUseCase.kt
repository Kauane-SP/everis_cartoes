package com.example.cartoeseveris.useCase

import com.example.cartoeseveris.model.CartoesModel
import com.example.cartoeseveris.repository.CallbackImplementation
import com.example.cartoeseveris.repository.CartoesRepository

class CartoesUseCase(private val repository: CartoesRepository) : CallbackImplementation {

    override suspend fun requestCartoes(
        callbackSuccess: (success: List<CartoesModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    ) {
        repository.requestCartoes(callbackSuccess, callbackError)
    }

}