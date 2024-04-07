package com.example.lab2.network

import android.telecom.Call
import com.example.lab2.model.AnimalApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimalService {
    @GET("animals?name=cheetah")
    @Headers("X-Api-Key: bRgp1yKPuQevSF4bMIPc2Q==pjRZmVXKHIybAGhg")
    fun fetchAnimalList(): Call<AnimalApiResponse>
}