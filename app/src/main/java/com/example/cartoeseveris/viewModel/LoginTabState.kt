package com.example.cartoeseveris.viewModel

sealed class LoginTabState {

    data class GetServicesFirebaseError(
        val error: String
    ): LoginTabState()

    data class GetServicesFirebaseSuccess(
        val success: String
    ): LoginTabState()
}