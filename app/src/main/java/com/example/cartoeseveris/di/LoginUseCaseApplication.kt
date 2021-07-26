package com.example.cartoeseveris.di

import com.example.cartoeseveris.useCase.LoginUseCase
import org.koin.dsl.module

val LoginUseCaseApplication = module {
    factory { LoginUseCase(get()) }
}