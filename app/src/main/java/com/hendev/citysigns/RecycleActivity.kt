package com.hendev.citysigns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hendev.citysigns.databinding.ActivityRecycleBinding

class RecycleActivity : AppCompatActivity() {

    private lateinit var dataList: ArrayList<Landmark>
    private lateinit var binding: ActivityRecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        createNewInit();
        getDataFromMain()
        bindDataToRow()
    }

    private fun createNewInit() {
        dataList = ArrayList<Landmark>()
    }

    private fun getDataFromMain() {
        val intent = intent
        dataList = intent.getSerializableExtra("landmarkList") as (ArrayList<Landmark>)
    }

    private fun bindDataToRow() {
        val landmarkAdaptor = LandmarkAdaptor(dataList)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = landmarkAdaptor
    }
}