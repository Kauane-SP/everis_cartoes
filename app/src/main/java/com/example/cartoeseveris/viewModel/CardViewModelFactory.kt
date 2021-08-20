package com.example.cartoeseveris.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartoeseveris.useCase.CardUseCase

class CardViewModelFactory(private val useCase: CardUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CardViewModel(useCase) as T
}