package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab2.adapter.AnimalAdapter
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.model.Animal
import com.example.lab2.model.AnimalDataSource

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var adapter: AnimalAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AnimalAdapter(
            onAnimalClick = {
                handleAnimalClick(it)
            },
            onAnimalRemoved = {
                handleAnimalRemoval(it)
            }
        )

        binding.recyclerView.adapter = adapter
        adapter?.setData(AnimalDataSource.animalList)
    }

    private fun handleAnimalClick(animal: Animal){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.KEY_RESULT, animal.name)
        startActivity(intent)
    }

    private fun handleAnimalRemoval(animal: Animal){
        val animalList = AnimalDataSource.animalList
        animalList.remove(animal)

        adapter?.setData(animalList)
    }
}