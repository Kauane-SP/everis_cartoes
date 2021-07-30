package com.example.cartoeseveris.api

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.Executor

class ImplementationBiometric(

) {

    fun biometricImplementation(
        context: Context,
        activity: FragmentActivity,
        success: () -> Unit,
        error: () -> Unit
    ) : BiometricPrompt{
        val prompt: BiometricPrompt
        val executor: Executor

        executor = ContextCompat.getMainExecutor(context)
        prompt = BiometricPrompt(
            activity,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    Toast.makeText(
                        context,
                        "Authentication error: $errString", Toast.LENGTH_SHORT
                    )
                        .show()
                    error.invoke()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    success.invoke()

                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(
                        context, "Authentication failed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    error.invoke()
                }
            })
        return prompt

    }
}