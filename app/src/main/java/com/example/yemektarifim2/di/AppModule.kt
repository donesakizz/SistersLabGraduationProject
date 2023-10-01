package com.example.yemektarifim2.di

import com.example.yemektarifim2.data.repo.RecipeDaRepository
import com.example.yemektarifim2.retrofit.ApiUtils
import com.example.yemektarifim2.retrofit.RecipesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideYemeklerDaRepository(recipesDao: RecipesDao): RecipeDaRepository {
        return RecipeDaRepository(recipesDao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao(): RecipesDao {
        return ApiUtils.getYemeklerDao()
    }
}