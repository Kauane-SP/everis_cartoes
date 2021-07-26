package com.example.cartoeseveris.di

import com.example.cartoeseveris.repository.LoginRepository
import kotlinx.coroutines.channels.Channel
import org.koin.dsl.module

val LoginRepositoryApplication = module {
    factory { LoginRepository(get()) }
}