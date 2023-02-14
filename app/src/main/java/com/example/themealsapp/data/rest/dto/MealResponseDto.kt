package com.example.themealsapp.data.rest.dto

import com.google.gson.annotations.SerializedName

class MealResponseDto {
    @SerializedName("meals")
    val meals: List<MealInfoDto>? = null
}