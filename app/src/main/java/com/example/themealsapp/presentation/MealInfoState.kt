package com.example.themealsapp.presentation

import com.example.themealsapp.domain.model.Meal

data class MealInfoState(
    val mealInfoItems: List<Meal> = emptyList(),
    val isLoading: Boolean = false
)
