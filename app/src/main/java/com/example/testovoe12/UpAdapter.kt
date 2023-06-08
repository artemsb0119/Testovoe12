package com.example.testovoe12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UpAdapter(val ups: List<Up>) : RecyclerView.Adapter<UpAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ups_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val up = ups[position]
        holder.textViewValuta.text = up.valuta
        holder.textViewPrice.text = up.price.toString()
        holder.textViewUp.text = up.up
        Glide.with(holder.itemView.context).load(up.image).into(holder.imageCoin)
        holder.imageArrow.setImageResource(R.drawable.arrow)
    }

    override fun getItemCount(): Int {
        return ups.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCoin: ImageView = itemView.findViewById(R.id.imageCoin)
        val textViewValuta: TextView = itemView.findViewById(R.id.textViewValuta)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val textViewUp: TextView = itemView.findViewById(R.id.textViewNews)
        val imageArrow: ImageView = itemView.findViewById(R.id.imageArrow)
    }
}