package com.example.cartoeseveris.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.adapter.CardAdapter
import com.example.cartoeseveris.model.CardModel
import com.example.cartoeseveris.repository.CardRepository
import com.example.cartoeseveris.useCase.CardUseCase
import com.example.cartoeseveris.viewModel.states.CardTabState
import com.example.cartoeseveris.viewModel.CardViewModel
import com.example.cartoeseveris.viewModel.CardViewModelFactory
import com.example.cartoeseveris.viewModel.events.CardTabEvent
import com.google.firebase.auth.FirebaseAuth

class Home : Fragment() {

    private lateinit var btLogout: AppCompatButton
    private lateinit var recyclerList: RecyclerView
    private lateinit var viewModel: CardViewModel
    private lateinit var listCards: List<CardModel>
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//      btLogout = view.findViewById(R.id.bt_logout)
//        btLogout.setOnClickListener {
//            logoutUser()
//        }

        val context = activity as Context
        listCards = listOf()
        progressBar = view.findViewById(R.id.services_loading)
        recyclerList = view.findViewById(R.id.recycler_cards)
        initViewModel(context, listCards)

    }
//
//    fun logoutUser() {
//        FirebaseAuth.getInstance().signOut()
//        controllerInstance.navigate(R.id.action_home2_to_login)
//    }

    fun initViewModel(context: Context, list: List<CardModel>) {
        val repository = CardRepository()
        val useCase = CardUseCase(repository)

        viewModel = ViewModelProvider(
            this,
            CardViewModelFactory(useCase)
        ).get(CardViewModel::class.java)
        initObserverState(context, list)
        initObserverEvent()
    }

    private fun initObserverEvent() {
        viewModel.viewEvent.observe(viewLifecycleOwner, Observer { viewEvent ->
            viewEvent.let {
                when (it) {
                    is CardTabEvent.ShowCardLoading -> onShowLoading()
                }
            }
        })
    }


    private fun initObserverState(context: Context, list: List<CardModel>) {
        viewModel.init(list)
        viewModel.viewState.observe(viewLifecycleOwner, Observer { status ->
            status.let {
                when (it) {
                    is CardTabState.GetServicesCard -> {
                        fillService(it.cartoes, context)
                    }
                    is CardTabState.GetServicesCardError -> {
                        onServiceError(it.exception)
                    }
                }
            }
        })
    }

    private fun onShowLoading() {
        progressBar.visibility = View.VISIBLE

    }

    private fun onServiceError(error: String) {
        val transition = activity?.supportFragmentManager?.beginTransaction()
        transition?.replace(R.id.fragment_content_error_generic, ErrorGeneric())

    }

    private fun fillService(services: List<CardModel>, activity: Context) {
        recyclerList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerList.adapter = CardAdapter(services, activity)
        progressBar.visibility = View.GONE
    }

    companion object{
        fun newInstance() = Home()
    }
}