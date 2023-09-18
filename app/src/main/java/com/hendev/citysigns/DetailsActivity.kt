package com.hendev.citysigns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hendev.citysigns.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getAndBindData();
    }

    private fun getAndBindData() {
        val intent = intent
        val receivedData = intent.getSerializableExtra("landmark") as Landmark
        binding.txtCityName.text = receivedData.country
        binding.txtIconName.text = receivedData.name
        binding.txtInformation.text = receivedData.information
        binding.imageView.setImageResource(receivedData.image)
    }
}