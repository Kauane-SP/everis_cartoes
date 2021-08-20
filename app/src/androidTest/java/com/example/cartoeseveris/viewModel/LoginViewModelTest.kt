package com.example.cartoeseveris.viewModel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cartoeseveris.model.LoginModel
import com.example.cartoeseveris.useCase.LoginUseCase
import com.example.cartoeseveris.viewModel.states.LoginTabState
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.ext.isInt

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest : TestCase(){

    @MockK
    lateinit var mockedUseCase: LoginUseCase

    lateinit var mockedLoginModel: LoginModel

    lateinit var mockedLoginViewModel: LoginViewModel



    @Before
    override fun setUp() {
        super.setUp()
        mockedLoginViewModel = LoginViewModel(mockedUseCase)

    }

    @Test
    fun teste (){
        if (mockedLoginModel.email.isInt() && mockedLoginModel.register.isInt()){
            runBlocking {
                val result = mockedLoginViewModel.viewState.value

                Assert.assertEquals(
                    LoginTabState.GetServicesFirebaseError("Deu ruim"),
                    result
                )
            }
        }
    }

}