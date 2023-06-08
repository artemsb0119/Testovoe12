package com.example.testovoe12

import android.provider.Telephony.Mms.Rate
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

class RateAdapter(val crypts: List<Crypta>) : RecyclerView.Adapter<RateAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypta = crypts[position]
        holder.textViewValuta.text = crypta.valuta
        val randomValue = (crypta.price * (0.9 + Math.random() * 0.2)).toFloat()
        val roundedValue = String.format("%.2f", randomValue)
        holder.textViewPrice.text = roundedValue
        val currentTime = Date()
        val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val timeString = timeFormat.format(currentTime)
        holder.textViewUpdate.text = "Time of last update: "+timeString
        Glide.with(holder.itemView.context).load(crypta.image).into(holder.imageCoin)
    }

    override fun getItemCount(): Int {
        return crypts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCoin: ImageView = itemView.findViewById(R.id.imageCoin)
        val textViewValuta: TextView = itemView.findViewById(R.id.textViewValuta)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val textViewUpdate: TextView = itemView.findViewById(R.id.textViewUpdate)
    }
}