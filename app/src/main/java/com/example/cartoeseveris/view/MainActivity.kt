package com.example.cartoeseveris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cartoeseveris.R
import com.example.cartoeseveris.fragments.Home
import com.example.cartoeseveris.fragments.User
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private lateinit var chipTransition: ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content_main, Home.newInstance())
            commit()
        }

        chipTransition = findViewById(R.id.menu_navigation_main)
        chipNavigationView()
    }

    private fun chipNavigationView() {
        chipTransition.setOnItemSelectedListener { id ->
            when (id) {

                R.id.home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.content_main, Home.newInstance())
                        commit()
                    }
                }
                R.id.users -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.content_main, User.newInstance())
                        commit()
                    }
                }
            }
        }
    }
}