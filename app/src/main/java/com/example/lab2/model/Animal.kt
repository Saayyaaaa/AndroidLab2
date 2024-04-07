package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class Animal(
    val kingdom: String,
    val phylum: String,
    val order: String,
    val family: String,
    val genus: String,
    val scientificName: String
)


