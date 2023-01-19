package com.omersungur.landmarkbook_android

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.omersungur.landmarkbook_android.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList: ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkViewHolder>() {
    class LandmarkViewHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkViewHolder(binding)
        //xml'i bağlama işini burada yapıyoruz.
    }

    override fun getItemCount(): Int {
        return landmarkList.size
        //ne kadar row göstereceğimizi burada belirtiyoruz.
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        //xml bağlandıktan sonra ne yapılacak burada yapıyoruz.
        holder.binding.recyclerViewTextView.text = landmarkList[position].name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList[position])
            holder.itemView.context.startActivity(intent)

        }
    }
}