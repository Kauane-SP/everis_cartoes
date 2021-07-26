package com.example.cartoeseveris.repository

import android.content.Context
import android.view.View
import com.example.cartoeseveris.BackendException
import com.example.cartoeseveris.LoginModel
import com.example.cartoeseveris.ui.CustomDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository(val api: BackendException) {
    suspend fun getUserPasswordLogin(
        loginModel: LoginModel,
        context: Context,
        view: View,
        dialog: CustomDialog,
        success: () -> Unit,
        error: () -> Unit,
    ) {
        withContext(Dispatchers.IO)
        {
            api.successBackend(
                loginModel,
                context,
                view,
                dialog,
                success,
                error
            )
        }
    }
}