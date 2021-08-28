package com.example.cartoeseveris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartoeseveris.R
import com.example.cartoeseveris.fragments.Login

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content_login, Login.newInstance())
            commit()
        }
    }
}