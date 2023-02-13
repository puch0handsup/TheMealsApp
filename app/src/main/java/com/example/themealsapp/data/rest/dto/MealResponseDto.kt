package com.example.themealsapp.data.rest.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MealResponseDto {
    @Json(name = "meals")
    val meals: List<MealInfoDto>? = null
}