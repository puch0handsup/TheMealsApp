package com.example.themealsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.themealsapp.data.local.entity.MealInfoEntity
import com.example.themealsapp.domain.model.Meal

@Dao
interface MealInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealInfos(infos: List<MealInfoEntity>?)

    @Query("DELETE FROM mealinfoentity WHERE strMeal IN(:strMeals)")
    suspend fun deleteMealInfos(meals: List<String?>?)

    @Query("SELECT * FROM mealinfoentity WHERE strMeal LIKE '%' || :strMeal || '%' ")
    suspend fun getMealInfos(meal: String): List<MealInfoEntity>
}