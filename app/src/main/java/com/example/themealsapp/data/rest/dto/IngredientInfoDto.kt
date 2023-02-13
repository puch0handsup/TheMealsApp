package com.example.themealsapp.data.rest.dto


import com.example.themealsapp.domain.model.Ingredient
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientInfoDto(
    @Json(name = "idIngredient")
    val idIngredient: String? = null,
    @Json(name = "strDescription")
    val strDescription: String? = null,
    @Json(name = "strIngredient")
    val strIngredient: String? = null,
    @Json(name = "strType")
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