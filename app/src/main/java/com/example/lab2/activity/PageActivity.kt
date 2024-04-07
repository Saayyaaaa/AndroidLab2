package com.example.lab2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.lab2.R

class PageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val uiHandler = Handler(Looper.getMainLooper())

        uiHandler.postDelayed({
            val intent = Intent(this@PageActivity, SectionActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}