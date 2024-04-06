package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.fragment.AnimalListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalListFragment = AnimalListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, animalListFragment)
            .commit()
    }
}