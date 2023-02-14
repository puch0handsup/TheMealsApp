package com.example.themealsapp.di

import com.example.themealsapp.data.repository.MealInfoRepositoryImpl
import com.example.themealsapp.domain.repository.MealInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * [Abstract Class] - Module for repository
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

//    @Binds
//    abstract fun provideMealsRepository(
//        mealInfoRepositoryImpl: MealInfoRepositoryImpl
//    ): MealInfoRepository

}