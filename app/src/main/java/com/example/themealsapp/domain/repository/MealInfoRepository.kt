package com.example.themealsapp.domain.repository

import com.example.themealsapp.domain.model.Meal
import com.example.themealsapp.utils.UIState
import kotlinx.coroutines.flow.Flow

interface MealInfoRepository {
    fun getMealInfos(query: String): Flow<UIState<List<Meal>>>
}