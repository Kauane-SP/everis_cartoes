package com.example.cartoeseveris.repository

import com.example.cartoeseveris.api.cartoesApi.CardApiTask
import com.example.cartoeseveris.model.CardModel
import com.example.cartoeseveris.viewModel.states.CardTabState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardRepository() : CallbackImplementation {

    override suspend fun requestCards(
        callbackSuccess: (successes: List<CardModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    ) {

        val cardApiTask = CardApiTask()

        withContext(Dispatchers.IO) {
            val request = cardApiTask.cartoesApi().getCartoesApi()

            request.enqueue(object : Callback<List<CardModel>> {
                override fun onResponse(
                    call: Call<List<CardModel>>,
                    response: Response<List<CardModel>>
                ) {
                    if (response.isSuccessful) {
                        callbackSuccess.invoke(response.body())
                    }

                }

                override fun onFailure(call: Call<List<CardModel>>, t: Throwable) {
                    CardTabState.GetServicesCardError(t.message.toString())
                    callbackError.invoke(t.message.toString())
                }
            })
        }
    }
}