package com.example.cartoeseveris

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.cartoeseveris.ui.CustomDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

interface BackendException {

    fun successBackend(
        emailLogin: String,
        registerLogin: String,
        context: Context,
        view: View,
        dialog: CustomDialog,
        success: () -> Unit,
        error: () -> Unit
    ) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(emailLogin, registerLogin)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    success.invoke()
                    Toast.makeText(context, "welcome", Toast.LENGTH_SHORT).show()
                } else {
                    error.invoke()
                }
            }
            .addOnFailureListener {
                when (it) {
                    is FirebaseAuthWeakPasswordException -> {
                        error.invoke()
                        dialog.dialogInstance(
                            view,
                            context.getString(R.string.warning),
                            context.getString(R.string.register_failed)
                        )
                    }
                    else -> {
                        error.invoke()
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

