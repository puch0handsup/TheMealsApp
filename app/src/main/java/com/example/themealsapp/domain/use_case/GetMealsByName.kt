package com.example.themealsapp.domain.use_case

import com.example.themealsapp.domain.model.Meal
import com.example.themealsapp.domain.repository.MealInfoRepository
import com.example.themealsapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMealsByName(
    private val repository: MealInfoRepository
) {
    operator fun invoke(query: String): Flow<UIState<List<Meal>>> {
        if (query.isBlank())
            return flow {  }
        return flow { repository.getMealInfos(query) }
    }
}