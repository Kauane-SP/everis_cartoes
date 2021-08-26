package com.example.cartoeseveris.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.biometric.BiometricPrompt
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cartoeseveris.api.BackendException
import com.example.cartoeseveris.model.LoginModel
import com.example.cartoeseveris.R
import com.example.cartoeseveris.api.ImplementationBiometric
import com.example.cartoeseveris.repository.LoginRepository
import com.example.cartoeseveris.ui.CustomDialog
import com.example.cartoeseveris.useCase.LoginUseCase
import com.example.cartoeseveris.view.MainActivity
import com.example.cartoeseveris.viewModel.states.LoginTabState
import com.example.cartoeseveris.viewModel.LoginViewModel
import com.example.cartoeseveris.viewModel.LoginViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class Login : Fragment() {

    private lateinit var registerBiometric: ImplementationBiometric
    private lateinit var btLogin: AppCompatButton
    private lateinit var loginModel: LoginModel
    private lateinit var registerLogin: AppCompatEditText
    private lateinit var emailLogin: AppCompatEditText
    private lateinit var dialog: CustomDialog
    private lateinit var api: BackendException
    private lateinit var viewModel: LoginViewModel
    private lateinit var btImageBiometric: AppCompatImageView
    private lateinit var info: BiometricPrompt.PromptInfo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        registerBiometric = ImplementationBiometric()
        btImageBiometric = view.findViewById(R.id.button_image_biometric)
        btLogin = view.findViewById(R.id.bt_login)
        emailLogin = view.findViewById(R.id.ed_text_email_login)
        registerLogin = view.findViewById(R.id.ed_text_register_login)

        val context = activity as Context
        dialog = CustomDialog()

        checksRegister()
        initViewModel()
        setOnClickBiometric(context)
        setOnClickBottomLogin(context, view)
    }

    private fun initViewModel() {
        api = BackendException()
        val repository = LoginRepository(api)
        val useCase = LoginUseCase(repository)
        viewModel = ViewModelProvider(
            this, LoginViewModelFactory(useCase)
        ).get(LoginViewModel::class.java)
    }

    fun initObserverState(context: Context, view: View, loginModel: LoginModel) {
        viewModel.init(loginModel, context, view, dialog)
        viewModel.viewState.observe(viewLifecycleOwner, { viewEvent ->
            when (viewEvent) {
                is LoginTabState.GetServicesFirebaseSuccess -> {
                    successCallBack()
                }
                is LoginTabState.GetServicesFirebaseError -> {
                    Toast(context)
                }
            }
        })
    }

    private fun setOnClickBottomLogin(context: Context, view: View) {
        btLogin.setOnClickListener {

            loginModel = LoginModel(emailLogin.text.toString(), registerLogin.text.toString())
            initObserverState(context, view, loginModel)
        }
    }

    private fun setOnClickBiometric(context: Context) {
        btImageBiometric.setOnClickListener {
            val biometric = registerBiometric.biometricImplementation(
                context,
                requireActivity(),
                ::successCallBack,
                ::errorCallBack
            )

            info = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for my app")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build()
            biometric.authenticate(info)
        }
    }

    private fun checksRegister() {
        val userRegister = FirebaseAuth.getInstance().currentUser

        if (userRegister != null) {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun successCallBack() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
    }

    private fun errorCallBack() {
        Toast.makeText(context, "Erro ! Tente novamente", Toast.LENGTH_SHORT)
    }

    companion object {
        fun newInstance() = Login()
    }
}