package com.example.themealsapp.data.repository

import android.util.Log
import com.example.themealsapp.data.local.MealInfoDao
import com.example.themealsapp.data.rest.MealsAPI
import com.example.themealsapp.domain.model.Meal
import com.example.themealsapp.domain.repository.MealInfoRepository
import com.example.themealsapp.utils.FailureResponse
import com.example.themealsapp.utils.NullResponse
import com.example.themealsapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "MealInfoRepositoryImpl"
class MealInfoRepositoryImpl @Inject constructor(
    private val mealsAPI: MealsAPI,
    private val mealDao: MealInfoDao
): MealInfoRepository {

    override fun getMealInfos(query: String): Flow<UIState<List<Meal>>> = flow {
        emit(UIState.LOADING())

        try {
            Log.d(TAG, "getMealInfos: Fetching data from API")
            val response = mealsAPI.searchMealByName(query)
            if (response.isSuccessful) {
                response.body()?.let { mealsResponse ->
                    val mealInfos = mealsResponse.meals
                    mealDao.deleteMealInfos(mealInfos?.map { it.strMeal })
                    mealDao.insertMealInfos(mealInfos?.map { it.toMealInfoEntity() })
                    val newMealsInfos = mealDao.getMealInfos(query)
                    emit(UIState.SUCCESS(newMealsInfos.map { it.toMeal() }))
                } ?: throw NullResponse()
            } else throw FailureResponse(response.errorBody()?.string())
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

    override fun getMealInfosLocally(query: String): Flow<UIState<List<Meal>>> = flow {
        try {
            Log.d(TAG, "getMealInfosLocally: Fetching data from local database")
            val newMealsInfos = mealDao.getMealInfos(query)
            emit(UIState.SUCCESS(newMealsInfos.map { it.toMeal() }))
            throw NullResponse()
        } catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }

}