package com.example.tz1.ui.store

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R
import com.example.tz1.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        prefs = requireActivity().getSharedPreferences("wallet", Context.MODE_PRIVATE)

        val imgprod : List<Int> = mutableListOf(
            R.drawable.imgprod1, R.drawable.imgprod2,
            R.drawable.imgprod3, R.drawable.imgprod4,
            R.drawable.imgprod5)

        val products : List<String> = this.resources.getStringArray(R.array.products).toList()
        val price : List<String> = this.resources.getStringArray(R.array.price).toList()
        val prod_urls : List<String> =this.resources.getStringArray(R.array.prod_urls).toList()

        val root = inflater.inflate(R.layout.fragment_store, container, false)
        val recyclerView : RecyclerView = root.findViewById(R.id.recycler_store)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = StoreAdapter(products, price, prod_urls, imgprod, prefs)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}