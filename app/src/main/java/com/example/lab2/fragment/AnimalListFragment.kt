package com.example.lab2.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab2.R
import com.example.lab2.SecondActivity
import com.example.lab2.adapter.AnimalAdapter
import com.example.lab2.databinding.FragmentAnimalListBinding
import com.example.lab2.model.Animal
import com.example.lab2.model.AnimalDataSource

class AnimalListFragment : Fragment() {

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = AnimalListFragment()
    }

    private var adapter: AnimalAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
//        val intent = Intent(requireContext(), SecondActivity::class.java)
//        intent.putExtra(SecondActivity.KEY_RESULT, animal.name)
//        startActivity(intent)

        val animalDetailsFragment = AnimalDetailsFragment.newInstance(animal.name)

        requireActivity().supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, animalDetailsFragment)
            .commit()
    }

    private fun handleAnimalRemoval(animal: Animal){
        val animalList = AnimalDataSource.animalList
        animalList.remove(animal)

        adapter?.setData(animalList)
    }


}