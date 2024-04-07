package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class Taxonomy (
    val kingdom: String,
    val phylum: String,
    val order: String,
    val family: String,
    val genus: String,
    @SerializedName("scientific_name")val scientificName: String
){
    companion object{
        fun toAnimal(taxonomy: Taxonomy) = Animal(
            kingdom = taxonomy.kingdom,
            phylum = taxonomy.phylum,
            order = taxonomy.order,
            family = taxonomy.family,
            genus = taxonomy.genus,
            scientificName = taxonomy.scientificName
        )
    }
}
