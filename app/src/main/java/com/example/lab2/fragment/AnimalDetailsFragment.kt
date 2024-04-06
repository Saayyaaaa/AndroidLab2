package com.example.lab2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.lab2.R
import com.example.lab2.databinding.FragmentAnimalDetailsBinding
import com.example.lab2.databinding.FragmentAnimalListBinding

class AnimalDetailsFragment : Fragment(){

    companion object {
        private const val KEY_ANIMAL_NAME = "animalName"
        fun newInstance(animalName: String) = AnimalDetailsFragment().apply {
            arguments = bundleOf(KEY_ANIMAL_NAME to animalName)
        }
    }

    private var _binding: FragmentAnimalDetailsBinding? = null
    private val binding get() = _binding!!

    private val name: String? by lazy{
        requireArguments().getString(KEY_ANIMAL_NAME)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.animalName.text = name
    }


}