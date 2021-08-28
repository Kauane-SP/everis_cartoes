package com.example.cartoeseveris.adapter.viewHolder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.model.CardModel
import com.example.cartoeseveris.view.customView.CircleProgress

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val numberCard: AppCompatTextView = itemView.findViewById(R.id.number_card)
    private val data: AppCompatTextView = itemView.findViewById(R.id.data_card)
    private val name: AppCompatTextView = itemView.findViewById(R.id.tv_name)
//    private val progress: CircleProgress = itemView.findViewById(R.id.card_cont_progress)

    fun onBind(cardModel: CardModel) {

        name.text = cardModel.name
        numberCard.text = cardModel.numberCard
        data.text = cardModel.codeCard
//        progress.setValues(cardModel.limited as Int)
    }
}