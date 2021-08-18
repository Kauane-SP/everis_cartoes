package com.example.cartoeseveris.adapter.viewHolder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.model.CartoesModel

class CartoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val numberCard: AppCompatTextView = itemView.findViewById(R.id.number_cartao)

    fun onBind(cartoesModel: CartoesModel) {

        numberCard.text = cartoesModel.numberCartoes
    }
}