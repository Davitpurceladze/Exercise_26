package com.example.exercise_26.domain.repository.home

import com.example.exercise_26.data.common.Resource
import com.example.exercise_26.domain.model.product.GetProducts
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun fetchProducts() : Flow<Resource<List<GetProducts>>>
}