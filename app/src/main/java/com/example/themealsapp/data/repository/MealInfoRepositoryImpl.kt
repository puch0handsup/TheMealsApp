package com.example.themealsapp.data.repository

import com.example.themealsapp.data.local.MealInfoDao
import com.example.themealsapp.data.rest.MealsAPI
import com.example.themealsapp.domain.model.Meal
import com.example.themealsapp.domain.repository.MealInfoRepository
import com.example.themealsapp.utils.FailureResponse
import com.example.themealsapp.utils.NullResponse
import com.example.themealsapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MealInfoRepositoryImpl(
    private val mealsAPI: MealsAPI,
    private val mealDao: MealInfoDao
): MealInfoRepository {

    override fun getMealInfos(query: String): Flow<UIState<List<Meal>>> = flow {
        emit(UIState.LOADING())

        val mealsStored = mealDao.getMealInfos(query).map { it.toMeal() }
        emit(UIState.LOADING(data = mealsStored))

        try {
            val response = mealsAPI.searchMealByName(query)
            if (response.isSuccessful) {
                response.body()?.let { mealsResponse ->
                    val mealInfos = mealsResponse.meals
                    mealDao.deleteMealInfos(mealInfos?.map { it.strMeal })
                    mealDao.insertMealInfos(mealInfos?.map { it.toMealInfoEntity() })
                    val newMealsInfos = mealDao.getMealInfos(query)
                    emit(UIState.SUCCESS(data = newMealsInfos.map { it.toMeal() }))
                } ?: throw NullResponse()
            } else throw FailureResponse(response.errorBody()?.string())
        } catch (e: Exception) {
            emit(UIState.ERROR(message = e.localizedMessage))
        }
    }

}