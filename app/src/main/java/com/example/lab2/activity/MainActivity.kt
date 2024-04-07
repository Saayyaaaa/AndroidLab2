package com.example.lab2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.R
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.fragment.AnimalListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, AnimalListFragment())
            .commit()
    }
}