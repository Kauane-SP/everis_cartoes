package com.example.cartoeseveris.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.adapter.viewHolder.CardViewHolder
import com.example.cartoeseveris.adapter.viewHolder.CardViewHolderTwo
import com.example.cartoeseveris.model.CardModel

class CardAdapter(private var list: List<CardModel>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            CARD_ONE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_item_cartao, parent, false)
                return CardViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_item_card_two, parent, false)
                return CardViewHolderTwo(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CARD_ONE -> {
                val viewHolder = holder as CardViewHolder
                viewHolder.onBind(list[position])
            }
            else -> {
                val viewHolder = holder as CardViewHolderTwo
                viewHolder.onBind(list[position])
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        if (list[position].id % 2 == 0) {
            return CARD_TWO
        } else {
            return CARD_ONE
        }
    }

    companion object {
        private const val CARD_ONE = 1
        private const val CARD_TWO = 0
    }
}