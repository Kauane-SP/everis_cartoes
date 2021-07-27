package com.example.cartoeseveris.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cartoeseveris.R
import com.google.firebase.auth.FirebaseAuth

class Home : Fragment() {

    private lateinit var btLogout: AppCompatButton
    private lateinit var controllerInstance: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        controllerInstance = Navigation.findNavController(view)
        btLogout = view.findViewById(R.id.bt_logout)
        btLogout.setOnClickListener {
            logoutUser()
        }
    }

    fun logoutUser() {
        FirebaseAuth.getInstance().signOut()
        controllerInstance.navigate(R.id.action_home2_to_login)
    }
}