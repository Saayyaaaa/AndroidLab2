package com.example.lab2.network

import com.example.lab2.model.Animal
import com.example.lab2.model.AnimalApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimalService {
    @GET("animals?name=cheetah")
    @Headers("X-Api-Key: bRgp1yKPuQevSF4bMIPc2Q==pjRZmVXKHIybAGhg")
    fun fetchAnimalList(): Call<AnimalApiResponse>

}