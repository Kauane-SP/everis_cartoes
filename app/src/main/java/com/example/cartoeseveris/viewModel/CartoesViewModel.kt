package com.example.cartoeseveris.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartoeseveris.model.CartoesModel
import com.example.cartoeseveris.useCase.CartoesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class CartoesViewModel(private val useCase: CartoesUseCase) : ViewModel() {

    private val state: MutableLiveData<CartoesTabState> = MutableLiveData()
    val viewState: LiveData<CartoesTabState> = state
    private val viewModeJob = SupervisorJob()
    private val coroutineContext = Dispatchers.Main + viewModeJob

    fun init(cartoesModel: List<CartoesModel>) {
        getServicesCartoes(cartoesModel)
    }


    private fun getServicesCartoes(cartoesModel: List<CartoesModel>) {
        CoroutineScope(coroutineContext).launch {
            try {
                useCase.requestCartoes(::successInvokeList, ::errorInvokeList)
                state.value = CartoesTabState.GetServicesCartoes(cartoesModel)
            } catch (excption: Exception) {
                state.value = CartoesTabState.GetServicesCartoesError(excption.toString())
            }
        }
    }

    private fun successInvokeList(list: List<CartoesModel>?) {
        if (list != null) {
            state.value = CartoesTabState.GetServicesCartoes(list)
        }
    }

    private fun errorInvokeList(exeption: String) {
        state.value = CartoesTabState.GetServicesCartoesError(exeption)
    }
}