package com.example.cartoeseveris.adapter.viewHolder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.model.CartoesModel
import java.text.SimpleDateFormat
import java.util.*

class CartoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val numberCard: AppCompatTextView = itemView.findViewById(R.id.number_cartao)
    private val data: AppCompatTextView = itemView.findViewById(R.id.data_card)

    fun onBind(cartoesModel: CartoesModel) {


        numberCard.text = cartoesModel.numberCartoes
        data.text = cartoesModel.dataVencimento
    }
}