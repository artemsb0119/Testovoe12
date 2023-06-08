package com.example.testovoe12

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide

class MenuActivity : AppCompatActivity() {

    private lateinit var buttonRate: AppCompatButton
    private lateinit var buttonUps: AppCompatButton
    private lateinit var buttonNews: AppCompatButton
    private lateinit var buttonSettings: AppCompatButton

    private lateinit var imageViewFon2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        buttonRate = findViewById(R.id.buttonRate)
        buttonUps = findViewById(R.id.buttonUps)
        buttonNews = findViewById(R.id.buttonNews)
        buttonSettings = findViewById(R.id.buttonSettings)
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

        buttonRate.setOnClickListener {
            val intent = Intent(this, RateActivity::class.java)
            startActivity(intent)
        }
        buttonUps.setOnClickListener {
            val intent = Intent(this, UpsActivity::class.java)
            startActivity(intent)
        }
        buttonNews.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}