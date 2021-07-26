package com.example.cartoeseveris.di

import com.example.cartoeseveris.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginViewModelApplication = module() {
    viewModel { LoginViewModel(useCase = get()) }
}