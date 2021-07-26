package com.example.cartoeseveris.di

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val LoginModelApplication = module {
    factory { Dispatchers.Main }
    factory { Dispatchers.IO }
}