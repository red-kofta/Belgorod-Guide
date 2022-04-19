package com.example.tz1.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tz1.MainActivity
import com.example.tz1.R
import com.example.tz1.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_menu, container, false)

        val images : List<Int> = mutableListOf(R.drawable.imgnews1, R.drawable.imgnews2,
                                                R.drawable.imgnews3, R.drawable.imgnews4,
                                                R.drawable.imgnews5, R.drawable.imgnews6,
                                                R.drawable.imgnews7, R.drawable.imgnews8,
                                                R.drawable.imgnews9,R.drawable.imgnews10,
                                                R.drawable.imgnews11,R.drawable.imgnews12,
                                                R.drawable.imgnews13)

        val viewPager: ViewPager = root.findViewById(R.id.img_slider)
        viewPager.adapter = ImageAdapter(images)

        val ents : List<String> =this.resources.getStringArray(R.array.ents).toList()

        val recyclerView : RecyclerView = root.findViewById(R.id.recycler_menu)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        recyclerView.adapter = MenuAdapter(ents)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}