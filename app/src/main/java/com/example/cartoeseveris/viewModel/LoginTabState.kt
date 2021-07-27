package com.example.cartoeseveris.viewModel

sealed class LoginTabState {

      class GetServicesFirebaseError(
        val error: String
    ): LoginTabState()

     class GetServicesFirebaseSuccess(
        val success: String
    ): LoginTabState()
}