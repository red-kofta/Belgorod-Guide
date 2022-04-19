package com.example.tz1.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tz1.R
import com.example.tz1.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private var id = -1
    private var items: List<String> = arrayListOf()
    lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arguments = intent.extras
        if (arguments != null) {
            id = arguments.getInt("id")
        }

        if (id == 0){
            items = this.resources.getStringArray(R.array.tc).toList()
        }
        if (id == 1){
            items = this.resources.getStringArray(R.array.cinemas).toList()
        }
        if (id == 2){
            items = this.resources.getStringArray(R.array.theaters).toList()
        }
        if (id == 3){
            items = this.resources.getStringArray(R.array.clubs).toList()
        }
        if (id == 4){
            items = this.resources.getStringArray(R.array.museums).toList()
        }

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(items)
    }

    private fun init(items: List<String>){
        binding.apply {
            val recyclerView : RecyclerView = root.findViewById(R.id.recycler_info)
            recyclerView.layoutManager = LinearLayoutManager(this@InfoActivity)
            recyclerView.adapter = InfoAdapter(items)
        }
    }
}