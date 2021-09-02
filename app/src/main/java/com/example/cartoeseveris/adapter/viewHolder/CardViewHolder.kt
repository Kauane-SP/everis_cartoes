package com.example.cartoeseveris.adapter.viewHolder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.api.Constants
import com.example.cartoeseveris.model.CardModel
import com.example.cartoeseveris.view.customView.CircleProgress

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val numberCard: AppCompatTextView = itemView.findViewById(R.id.number_card)
    private val data: AppCompatTextView = itemView.findViewById(R.id.data_card)
    private val name: AppCompatTextView = itemView.findViewById(R.id.tv_name)

    fun onBind(cardModel: CardModel) {

        name.text = cardModel.name
        numberCard.text = cardModel.numberCard
        data.text = cardModel.codeCard
//        if (cardModel.limited >= Constants.LIMITED.toString()){
//            progress.setValues(cardModel.limited as Int, isUnlimitedTotal = true)
//        }else {
//            progress.setValues(cardModel.limited as Int)
//        }
    }
}