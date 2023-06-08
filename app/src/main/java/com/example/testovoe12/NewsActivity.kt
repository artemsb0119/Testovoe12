package com.example.testovoe12

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class NewsActivity : AppCompatActivity() {

    private lateinit var news: List<News>
    private lateinit var activity: Activity
    private lateinit var imageViewFon2: ImageView

    private lateinit var viewpager: ViewPager2
    private lateinit var buttonNext: AppCompatButton
    private lateinit var adapter: NewsAdapter

    private var currentItemIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        buttonNext = findViewById(R.id.buttonNext)
        viewpager = findViewById(R.id.viewpager)
        imageViewFon2 = findViewById(R.id.imageViewFon2)
        activity = this

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
        loadData()

        buttonNext.setOnClickListener {
            currentItemIndex = viewpager.currentItem
            currentItemIndex++
            if (currentItemIndex >= news.size-1) {
                buttonNext.visibility=View.INVISIBLE
            }
            viewpager.setCurrentItem(currentItemIndex, true)
        }
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val data = URL("http://135.181.248.237/12/news.json").readText()
                val gson = Gson()
                news = gson.fromJson(data, Array<News>::class.java).toList()

                activity.runOnUiThread {
                    adapter = NewsAdapter(news)
                    viewpager.adapter = adapter
                    viewpager.clipToPadding = false
                    viewpager.clipChildren = false
                    viewpager.isUserInputEnabled = false
                    viewpager.offscreenPageLimit = 2
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}