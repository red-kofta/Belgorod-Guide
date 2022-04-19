package com.example.tz1.ui.news

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

class NewsAdapter(private val headers: List<String>, private val footers: List<String>,
                  private val news_urls: List<String>, private val img_news: List<Int>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
        class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textNewsHeaderView: TextView = itemView.findViewById(R.id.textNewsHeader)
            val imgNewsValue : ImageView = itemView.findViewById(R.id.imgNews)
            val textNewsFooterView: TextView = itemView.findViewById(R.id.textNewsFooter)
        }

    override fun getItemCount() = headers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.textNewsHeaderView.text = headers[position]

        val image : Drawable = holder.imgNewsValue.resources.getDrawable(img_news[position])
        holder.imgNewsValue.setImageDrawable(image)

        holder.textNewsFooterView.text = footers[position]

        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(news_urls[position]));
            it.context.startActivity(browserIntent);
        }
    }
}