package com.example.lab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.ItemAnimalBinding
import com.example.lab2.model.Animal
import java.io.File.separator

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    private val animalList: ArrayList<Animal> = ArrayList()

    fun setData(animals: ArrayList<Animal>){
        animalList.clear()
        animalList.addAll(animals)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun getItemCount() = animalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalList[position])
    }

    inner class ViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(animal: Animal){
            with(binding){
                animalName.text = animal.name
                animalTaxonomy.text = animal.taxonomy.joinToString(separator = ", ")
                animalLocation.text = animal.taxonomy.joinToString(separator = ", ")
            }
        }
    }
}