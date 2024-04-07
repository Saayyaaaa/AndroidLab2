package com.example.lab2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2.R
import com.example.lab2.databinding.ActivitySectionBinding

class SectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivitySectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            animalBtn.setOnClickListener {
                // Handler code here.
                val intent = Intent(this@SectionActivity, MainActivity::class.java)
                startActivity(intent);
            }
        }
    }
}