package com.example.testovoe12

import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class Crypta(
    @SerializedName("image") val image : String,
    @SerializedName("valuta") val valuta : String,
    @SerializedName("price") val price : Float,
    @SerializedName("time") val time : String
)
