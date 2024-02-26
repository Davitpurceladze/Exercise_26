package com.example.exercise_26.di

import com.example.exercise_26.data.common.HandleResponse
import com.example.exercise_26.data.repository.home.ProductsRepositoryImpl
import com.example.exercise_26.data.service.home.ProductsService
import com.example.exercise_26.domain.repository.home.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductsRepository(
        productsService: ProductsService,
        handleResponse: HandleResponse
    ): ProductsRepository {
        return ProductsRepositoryImpl(
            productsService = productsService,
            handleResponse = handleResponse
        )
    }
}