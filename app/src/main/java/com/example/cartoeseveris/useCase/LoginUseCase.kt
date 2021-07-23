package com.example.cartoeseveris.useCase


import android.content.Context
import android.view.View
import com.example.cartoeseveris.repository.LoginRepository
import com.example.cartoeseveris.ui.CustomDialog

class LoginUseCase(private val repository: LoginRepository) {

    suspend fun getLoginFirebase(
        emailLogin: String,
        registerLogin: String,
        context: Context,
        view: View,
        dialog: CustomDialog,
        success: () -> Unit,
        error: () -> Unit,
    ) {
        return repository.getUserPasswordLogin(
            emailLogin,
            registerLogin,
            context,
            view,
            dialog,
            success,
            error
        )
    }
}
