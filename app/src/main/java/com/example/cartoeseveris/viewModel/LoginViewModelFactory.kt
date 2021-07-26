package com.example.cartoeseveris.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartoeseveris.useCase.LoginUseCase

class LoginViewModelFactory(private val useCase: LoginUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>) = LoginViewModel(useCase) as T
}