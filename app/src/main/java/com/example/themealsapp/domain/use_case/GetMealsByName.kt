package com.example.themealsapp.domain.use_case

import android.net.ConnectivityManager
import com.example.themealsapp.di.NetworkModule
import com.example.themealsapp.domain.model.Meal
import com.example.themealsapp.domain.repository.MealInfoRepository
import com.example.themealsapp.utils.NetworkState
import com.example.themealsapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealsByName @Inject constructor(
    private val repository: MealInfoRepository,
    private val networkState: NetworkState
) {
    operator fun invoke(query: String): Flow<UIState<List<Meal>>> {
        if (query.isBlank() || !networkState.isInternetOn())
            return repository.getMealInfosLocally(query)
        return repository.getMealInfos(query)
    }
}