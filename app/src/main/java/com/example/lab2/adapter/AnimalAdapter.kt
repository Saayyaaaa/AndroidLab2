package com.example.lab2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.ItemAnimalBinding
import com.example.lab2.model.Animal
import java.io.File.separator

class AnimalAdapter(
    private val onAnimalClick: (Animal) -> Unit,
    private val onAnimalRemoved: (Animal) ->Unit
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    companion object{
        private const val ANIMAL_ADAPTER_TAG = "AnimalAdapter"
    }


    private val animalList: ArrayList<Animal> = ArrayList()

    fun setData(animals: ArrayList<Animal>){
        animalList.clear()
        animalList.addAll(animals)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(ANIMAL_ADAPTER_TAG, "onCreateViewHolder")
        return ViewHolder(
            ItemAnimalBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
            )
    }

    override fun getItemCount() = animalList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(ANIMAL_ADAPTER_TAG, "onBindViewHolder: $position")
        holder.bind(animalList[position])
    }

    inner class ViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(animal: Animal){
            with(binding){
                animalKingdom.text = animal.kingdom
                animalPhylum.text = animal.phylum
                animalOrder.text = animal.order
                animalFamily.text = animal.family
                animalGenus.text = animal.genus
                animalScientificName.text = animal.scientificName

                root.setOnClickListener{
                    onAnimalClick(animal)
                }
                removeAnimal.setOnClickListener{
                    onAnimalRemoved(animal)
                }
            }
        }
    }
}