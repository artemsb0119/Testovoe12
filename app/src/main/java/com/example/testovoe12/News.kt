package com.example.testovoe12

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title") val title: String,
    @SerializedName("text") val text: String
)
