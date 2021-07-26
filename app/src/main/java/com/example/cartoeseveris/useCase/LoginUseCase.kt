package com.example.cartoeseveris.useCase


import android.content.Context
import android.view.View
import com.example.cartoeseveris.LoginModel
import com.example.cartoeseveris.repository.LoginRepository
import com.example.cartoeseveris.ui.CustomDialog

class LoginUseCase(private val repository: LoginRepository) {

    suspend fun getLoginFirebase(
        loginModel: LoginModel,
        context: Context,
        view: View,
        dialog: CustomDialog,
        success: () -> Unit,
        error: () -> Unit,
    ) {
        return repository.getUserPasswordLogin(
            loginModel,
            context,
            view,
            dialog,
            success,
            error
        )
    }
}
