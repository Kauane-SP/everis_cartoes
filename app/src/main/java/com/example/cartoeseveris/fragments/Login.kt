package com.example.cartoeseveris.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cartoeseveris.api.BackendException
import com.example.cartoeseveris.model.LoginModel
import com.example.cartoeseveris.R
import com.example.cartoeseveris.repository.LoginRepository
import com.example.cartoeseveris.ui.CustomDialog
import com.example.cartoeseveris.useCase.LoginUseCase
import com.example.cartoeseveris.viewModel.LoginTabState
import com.example.cartoeseveris.viewModel.LoginViewModel
import com.example.cartoeseveris.viewModel.LoginViewModelFactory

class Login : Fragment() {

    private lateinit var btLogin: AppCompatButton
    private lateinit var loginModel: LoginModel
    private lateinit var registerLogin: AppCompatEditText
    private lateinit var emailLogin: AppCompatEditText
    private lateinit var dialog: CustomDialog
    private lateinit var api : BackendException
    private lateinit var viewModel: LoginViewModel
    private lateinit var controllerInstance: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btLogin = view.findViewById(R.id.bt_login)
        emailLogin = view.findViewById(R.id.ed_text_email_login)
        registerLogin = view.findViewById(R.id.ed_text_register_login)
        val context = activity as Context

        btLogin.setOnClickListener {

            loginModel = LoginModel(emailLogin.text.toString(), registerLogin.text.toString())
            observerViewState(context, view, loginModel )
        }

        dialog = CustomDialog()
        controllerInstance = Navigation.findNavController(view)
        initViewModel()

    }

    private fun initViewModel(){
        api = BackendException()
        val repository = LoginRepository(api)
        val useCase = LoginUseCase(repository)
        viewModel = ViewModelProvider(this, LoginViewModelFactory(useCase)
        ).get(LoginViewModel::class.java)
    }

    fun observerViewState(context: Context, view: View, loginModel: LoginModel){
        viewModel.init(loginModel, context, view, dialog)
        viewModel.viewState.observe(viewLifecycleOwner,  { viewEvent ->
                when(viewEvent){
                    is LoginTabState.GetServicesFirebaseSuccess -> {
                        controllerInstance.navigate(R.id.action_login_to_home2)
                    }
                    is LoginTabState.GetServicesFirebaseError -> {
                        Toast(context)
                    }
                }
        })
    }
}