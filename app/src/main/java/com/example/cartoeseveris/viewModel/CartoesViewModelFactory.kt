package com.example.cartoeseveris.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartoeseveris.useCase.CartoesUseCase

class CartoesViewModelFactory(private val useCase: CartoesUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CartoesViewModel(useCase) as T
}