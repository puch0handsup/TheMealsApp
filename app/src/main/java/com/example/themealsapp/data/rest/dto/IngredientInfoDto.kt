package com.example.themealsapp.data.rest.dto


import com.example.themealsapp.domain.model.Ingredient
import com.google.gson.annotations.SerializedName

data class IngredientInfoDto(
    @SerializedName("idIngredient")
    val idIngredient: String? = null,
    @SerializedName("strDescription")
    val strDescription: String? = null,
    @SerializedName("strIngredient")
    val strIngredient: String? = null,
    @SerializedName("strType")
    val strType: String? = null
) {
    fun toIngredient(): Ingredient {
        return Ingredient(
            idIngredient = idIngredient ?: "",
            strIngredient = strIngredient ?: "",
            strDescription = strDescription ?: "",
            strType = strType ?: ""
        )
    }
}