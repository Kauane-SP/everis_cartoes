package com.example.cartoeseveris.di

import com.example.cartoeseveris.api.BackendException
import org.koin.dsl.module

val BackendExceptionApplication = module {
    factory { BackendException() }
}