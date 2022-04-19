package com.example.tz1.ui.store

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R

class StoreAdapter(private val product: List<String>, private val price: List<String>,
                   private val prod_urls: List<String>, private val img_prod: List<Int>,
                   private val prefs: SharedPreferences) :
    RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProdValue : ImageView = itemView.findViewById(R.id.imgProduct)
        val textProductView: TextView = itemView.findViewById(R.id.textProduct)
        val textPriceView: TextView = itemView.findViewById(R.id.textPrice)
    }

    override fun getItemCount() = product.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.store_item, parent, false)
        return StoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val image : Drawable = holder.imgProdValue.resources.getDrawable(img_prod[position])
        holder.imgProdValue.setImageDrawable(image)

        holder.textProductView.text = product[position]

        holder.textPriceView.text = price[position] + " SK8"

        val balance = prefs.getInt("balance", 0)

        holder.itemView.setOnClickListener {
            if(balance >= price[position].toInt()){
                // записываем новый баланс
                val new_balance = balance - price[position].toInt()
                prefs.edit().putInt("balance", new_balance).apply()

                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(prod_urls[position]));
                it.context.startActivity(browserIntent);
            }
        }
    }
}