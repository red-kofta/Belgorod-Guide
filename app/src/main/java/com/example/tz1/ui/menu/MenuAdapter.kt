package com.example.tz1.ui.menu

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R

class MenuAdapter(private val ents: List<String>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textMenuView: TextView = itemView.findViewById(R.id.textMenu)
    }

    override fun getItemCount() = ents.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.textMenuView.text = ents[position]
        holder.itemView.setOnClickListener {
            val infoIntent = Intent(it.context, InfoActivity::class.java)
            infoIntent.putExtra("id", position)
            it.context.startActivity(infoIntent)
        }
    }
}