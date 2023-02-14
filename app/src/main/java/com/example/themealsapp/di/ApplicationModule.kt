package com.example.themealsapp.di

import android.content.Context
import androidx.room.Room
import com.example.themealsapp.data.local.MealInfoDao
import com.example.themealsapp.data.local.MealInfoDatabase
import com.example.themealsapp.data.repository.MealInfoRepositoryImpl
import com.example.themealsapp.data.rest.MealsAPI
import com.example.themealsapp.domain.repository.MealInfoRepository
import com.example.themealsapp.domain.use_case.GetMealsByName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesMealInfoUseCase(
        repository: MealInfoRepository
    ): GetMealsByName {
        return GetMealsByName(repository)
    }

    @Provides
    @Singleton
    fun providesMealInfoRepository(
        db: MealInfoDatabase,
        mealsAPI: MealsAPI
    ): MealInfoRepository {
        return MealInfoRepositoryImpl(mealDao = db.dao, mealsAPI = mealsAPI)
    }

    @Provides
    @Singleton
    fun providesMealInfoDao(
        db: MealInfoDatabase
    ): MealInfoDao {
        return db.dao
    }

    @Provides
    @Singleton
    fun providesMealInfoDatabase(
        @ApplicationContext context: Context
    ): MealInfoDatabase {
        return Room.databaseBuilder(
            context,
            MealInfoDatabase::class.java,
            "themealsapp_db"
        ).build()
    }
}