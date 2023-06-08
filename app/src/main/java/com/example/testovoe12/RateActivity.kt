package com.example.testovoe12

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class RateActivity : AppCompatActivity() {

    private lateinit var activity: Activity
    private lateinit var imageViewFon2: ImageView
    private lateinit var crypta: List<Crypta>

    private lateinit var rv_table: RecyclerView
    private lateinit var adapter: RateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)

        rv_table = findViewById(R.id.rv_table)
        rv_table.layoutManager = LinearLayoutManager(this)

        imageViewFon2 = findViewById(R.id.imageViewFon2)

        val sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        var currentNumber = sharedPreferences.getInt("currentNumber", 1)
        if(currentNumber==1) {
            Glide.with(this)
                .load("http://135.181.248.237/12/fon2.png")
                .into(imageViewFon2)
        } else if (currentNumber==2){
            Glide.with(this)
                .load("http://135.181.248.237/12/fon3.png")
                .into(imageViewFon2)
        } else if (currentNumber==3){
            Glide.with(this)
                .load("http://135.181.248.237/12/fon4.png")
                .into(imageViewFon2)
        }

        activity = this
        loadData()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL("http://135.181.248.237/12/crypto.json").readText()
                val gson = Gson()
                crypta = gson.fromJson(data, Array<Crypta>::class.java).toList()

                activity.runOnUiThread {
                    adapter = RateAdapter(crypta)
                    rv_table.adapter = adapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}