package com.example.testovoe12

import com.google.gson.annotations.SerializedName

data class Up(
    @SerializedName("image") val image : String,
    @SerializedName("valuta") val valuta : String,
    @SerializedName("price") val price : Float,
    @SerializedName("time") val time : String,
    @SerializedName("arrow") val arrow : String,
    @SerializedName("up") val up : String
)
