package com.example.cartoeseveris.adapter.viewHolder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.model.CardModel

class CardViewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val numberCard : AppCompatTextView = itemView.findViewById(R.id.number_card_two)
    private val data: AppCompatTextView = itemView.findViewById(R.id.data_card_two)
    private val name: AppCompatTextView = itemView.findViewById(R.id.tv_name_two)

    fun onBind(cardModel: CardModel){

        numberCard.text = cardModel.numberCard
        data.text = cardModel.codeCard
        name.text = cardModel.name
    }
}