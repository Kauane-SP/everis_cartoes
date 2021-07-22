package com.example.cartoeseveris.useCase

import android.content.Context
import android.view.View
import com.example.cartoeseveris.R
import com.example.cartoeseveris.ui.Dialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class LoginUseCase(private val dialog: Dialog) {

    suspend fun returnStateLogin(
        emailLogin: String,
        registerLogin: String,
        view: View,
        context: Context
    ) {

        FirebaseAuth.getInstance().signInWithEmailAndPassword(emailLogin, registerLogin)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                }
            }
            .addOnFailureListener {
                when (it) {
                    is FirebaseAuthWeakPasswordException -> {
                        dialog.dialogInstance(
                            view,
                            context.getString(R.string.warning),
                            context.getString(R.string.register_failed)
                        )
                    }
                    else -> {
                        dialog.dialogInstance(
                            view,
                            context.getString(R.string.warning),
                            context.getString(R.string.warning_simple)
                        )
                    }
                }

            }
    }
}