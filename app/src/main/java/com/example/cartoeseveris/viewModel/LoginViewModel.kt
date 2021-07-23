package com.example.cartoeseveris.viewModel

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartoeseveris.BackendException
import com.example.cartoeseveris.ui.CustomDialog
import com.example.cartoeseveris.useCase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LoginViewModel(private val useCase: LoginUseCase) : ViewModel() {

    private val state: MutableLiveData<LoginTabState> = MutableLiveData()
    val viewState: LiveData<LoginTabState> = state
    private val viewModelJob = SupervisorJob()
    private val coroutineContext = Dispatchers.Main + viewModelJob

    fun init(
        emailLogin: String,
        registerLogin: String,
        context: Context,
        view: View,
        dialog: CustomDialog
    ) {
        getObserverLogin(
            emailLogin,
            registerLogin,
            context,
            view,
            dialog
        )
    }

    private fun getObserverLogin(
        emailLogin: String,
        registerLogin: String,
        context: Context,
        view: View,
        dialog: CustomDialog
    ) {
        CoroutineScope(coroutineContext).launch {
            useCase.getLoginFirebase(
                emailLogin,
                registerLogin,
                context,
                view,
                dialog,
                ::successLogin,
                ::errorLogin
            )
        }
    }

    private fun successLogin() {
        state.postValue(LoginTabState.GetServicesFirebaseSuccess("deu bom"))
    }

    private fun errorLogin() {
        state.postValue(LoginTabState.GetServicesFirebaseError("Deu ruim"))
    }

}