package com.example.cartoeseveris.viewModel

sealed class LoginTabState {

     data class GetServicesFirebaseError(
        val error: String
    ): LoginTabState()

     class GetServicesFirebaseSuccess(
        val success: String
    ): LoginTabState()
}