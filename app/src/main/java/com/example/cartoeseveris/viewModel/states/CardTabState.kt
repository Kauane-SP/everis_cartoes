package com.example.cartoeseveris.viewModel.states

import com.example.cartoeseveris.model.CardModel

sealed class CardTabState {
    data class GetServicesCard(val cartoes: List<CardModel>) : CardTabState()

    data class GetServicesCardError(
        val exception: String
    ) : CardTabState()
}