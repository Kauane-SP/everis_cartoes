package com.example.cartoeseveris.viewModel

import com.example.cartoeseveris.model.CartoesModel

sealed class CartoesTabState {
    data class GetServicesCartoes(val cartoes: List<CartoesModel>) : CartoesTabState()

    data class GetServicesCartoesError(
        val exception: String
    ) : CartoesTabState()
}