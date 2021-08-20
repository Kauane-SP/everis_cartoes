package com.example.cartoeseveris.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R
import com.example.cartoeseveris.adapter.viewHolder.CartoesViewHolder
import com.example.cartoeseveris.model.CartoesModel

class CartoesAdapter(private var list: List<CartoesModel>, private val context: Context) :
    RecyclerView.Adapter<CartoesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartoesViewHolder {
        return CartoesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_cartao, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartoesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}