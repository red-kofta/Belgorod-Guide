package com.example.tz1.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R

class InfoAdapter(private val ent: List<String>) :
    RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {
    class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMenuView: TextView = itemView.findViewById(R.id.textInfo)
    }

    override fun getItemCount() = ent.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.info_item, parent, false)
        return InfoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.textMenuView.text = ent[position]
    }
}