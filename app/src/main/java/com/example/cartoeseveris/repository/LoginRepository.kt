package com.example.cartoeseveris.repository

import com.example.cartoeseveris.model.UserPasswordLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository() {
    suspend fun getUserPasswordLogin(
        idRegister: String,
        idEmail: String
    ): UserPasswordLogin =
        withContext(Dispatchers.IO){
            UserPasswordLogin(idRegister, idEmail)
        }
}