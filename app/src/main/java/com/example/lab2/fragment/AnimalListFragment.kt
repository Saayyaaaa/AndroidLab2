package com.example.lab2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab2.R
import com.example.lab2.adapter.AnimalAdapter
import com.example.lab2.databinding.FragmentAnimalListBinding
import com.example.lab2.model.Animal
import com.example.lab2.model.AnimalApiResponse
import com.example.lab2.model.AnimalDataSource
import com.example.lab2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        requireActivity().supportFragmentManager.setFragmentResultListener(
            "AnimalNameResult",
            viewLifecycleOwner
        ) { requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            AnimalDataSource.animalList.add(
                Animal(
                    kingdom = result!!,
                    phylum = "String",
                    order = "String",
                    family = "String",
                    genus = "String",
                    scientificName = "String"
                )
            )
            adapter?.setData(AnimalDataSource.animalList)
        }

        val client = ApiClient.instance
        val response = client.fetchAnimalList()

        response.enqueue(object : Callback <AnimalApiResponse>{
            override fun onResponse(
                call: Call<AnimalApiResponse>,
                response: Response<AnimalApiResponse>
            ) {
                println("HttpResponse: %response")
            }

            override fun onFailure(call: Call<AnimalApiResponse>, t: Throwable) {
                println("HttpResponse: %t")
            }

        })
    }





    private fun handleAnimalClick(animal: Animal){
//        val intent = Intent(requireContext(), SecondActivity::class.java)
//        intent.putExtra(SecondActivity.KEY_RESULT, animal.name)
//        startActivity(intent)

        val animalDetailsFragment = AnimalDetailsFragment.newInstance(animal.kingdom)

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