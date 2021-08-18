package com.example.cartoeseveris.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.adapter.CartoesAdapter
import com.example.cartoeseveris.model.CartoesModel
import com.example.cartoeseveris.repository.CartoesRepository
import com.example.cartoeseveris.useCase.CartoesUseCase
import com.example.cartoeseveris.viewModel.CartoesTabState
import com.example.cartoeseveris.viewModel.CartoesViewModel
import com.example.cartoeseveris.viewModel.CartoesViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class Home : Fragment() {

    private lateinit var btLogout: AppCompatButton
    private lateinit var controllerInstance: NavController
    private lateinit var recyclerList: RecyclerView
    private lateinit var viewModel: CartoesViewModel
    private lateinit var listCards: List<CartoesModel>

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
        val context = activity as Context
        listCards = listOf()

        recyclerList = view.findViewById(R.id.recycler_cards)
        initViewModel(context, listCards)

    }

    fun logoutUser() {
        FirebaseAuth.getInstance().signOut()
        controllerInstance.navigate(R.id.action_home2_to_login)
    }

    fun initViewModel(context: Context, list: List<CartoesModel>) {
        val repository = CartoesRepository()
        val useCase = CartoesUseCase(repository)

        viewModel = ViewModelProvider(
            this,
            CartoesViewModelFactory(useCase)
        ).get(CartoesViewModel::class.java)
        initObserverState(context, list)
    }


    private fun initObserverState(context: Context, list: List<CartoesModel>) {
        viewModel.init(list)
        viewModel.viewState.observe(viewLifecycleOwner, Observer { status ->
            status.let {
                when (it) {
                    is CartoesTabState.GetServicesCartoes -> {
                        fillService(it.cartoes, context)
                    }
                    is CartoesTabState.GetServicesCartoesError -> {
                        onServiceError(it.exception)
                    }
                }
            }
        })
    }

    private fun onServiceError(error: String) {

    }

    private fun fillService(services: List<CartoesModel>, activity: Context) {
        recyclerList.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerList.adapter = CartoesAdapter(services, activity)
    }
}