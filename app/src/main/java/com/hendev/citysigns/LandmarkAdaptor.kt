package com.hendev.citysigns

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hendev.citysigns.databinding.RecyclerRowBinding

class LandmarkAdaptor(val dataList: ArrayList<Landmark>) :
    RecyclerView.Adapter<LandmarkAdaptor.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.txtRecRow.text = dataList[position].name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("landmark", dataList[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}