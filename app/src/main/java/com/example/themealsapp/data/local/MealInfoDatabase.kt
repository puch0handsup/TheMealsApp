package com.example.themealsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.themealsapp.data.local.entity.MealInfoEntity

@Database(
    entities = [
        MealInfoEntity::class
    ],
    version = 1
)
abstract class MealInfoDatabase: RoomDatabase() {

    abstract val dao: MealInfoDao
}