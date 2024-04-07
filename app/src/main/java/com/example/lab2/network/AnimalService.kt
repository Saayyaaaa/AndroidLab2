package com.example.lab2.network

import com.example.lab2.model.Animal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimalService {
    @Headers("X-Api-Key: bRgp1yKPuQevSF4bMIPc2Q==pjRZmVXKHIybAGhg")
    @GET("animals?name=cheetah")


    fun fetchAnimalList(@Query("name") name: String): Call<List<Animal>>

}