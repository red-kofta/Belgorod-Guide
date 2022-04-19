package com.example.tz1.ui.news

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R
import com.example.tz1.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val imgnews : List<Int> = mutableListOf(R.drawable.imgnews1, R.drawable.imgnews2,
                                                R.drawable.imgnews3, R.drawable.imgnews4,
                                                R.drawable.imgnews5, R.drawable.imgnews6,
                                                R.drawable.imgnews7, R.drawable.imgnews8,
                                                R.drawable.imgnews9,R.drawable.imgnews10,
                                                R.drawable.imgnews11,R.drawable.imgnews12,
                                                R.drawable.imgnews13)

        val headers : List<String> = this.resources.getStringArray(R.array.news_headers).toList()
        val footers : List<String> = this.resources.getStringArray(R.array.news_footers).toList()
        val news_urls : List<String> =this.resources.getStringArray(R.array.news_urls).toList()

        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val recyclerView : RecyclerView = root.findViewById(R.id.recycler_news)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = NewsAdapter(headers, footers, news_urls, imgnews)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}