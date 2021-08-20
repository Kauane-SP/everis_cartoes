package com.example.cartoeseveris.repository

import com.example.cartoeseveris.api.cartoesApi.CartoesApiTask
import com.example.cartoeseveris.model.CartoesModel
import com.example.cartoeseveris.viewModel.CartoesTabState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartoesRepository() : CallbackImplementation {

    override suspend fun requestCartoes(
        callbackSuccess: (success: List<CartoesModel>?) -> Unit,
        callbackError: (error: String) -> Unit
    ) {

        val cartoesApiTask = CartoesApiTask()

        withContext(Dispatchers.IO) {
            val request = cartoesApiTask.cartoesApi().getCartoesApi()

            request.enqueue(object : Callback<List<CartoesModel>> {
                override fun onResponse(
                    call: Call<List<CartoesModel>>,
                    response: Response<List<CartoesModel>>
                ) {
                    if (response.isSuccessful) {
                        callbackSuccess.invoke(response.body())
                    }

                }

                override fun onFailure(call: Call<List<CartoesModel>>, t: Throwable) {
                    CartoesTabState.GetServicesCartoesError(t.message.toString())
                    callbackError.invoke(t.message.toString())
                }
            })
        }
    }
}