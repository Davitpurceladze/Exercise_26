package com.example.exercise_26.data.repository.home

import com.example.exercise_26.data.common.HandleResponse
import com.example.exercise_26.data.common.Resource
import com.example.exercise_26.data.mapper.base.asResource
import com.example.exercise_26.data.mapper.products.toDomain
import com.example.exercise_26.domain.model.product.GetProducts
import com.example.exercise_26.data.service.home.ProductsService
import com.example.exercise_26.domain.repository.home.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsService: ProductsService,
    private val handleResponse: HandleResponse
) : ProductsRepository {
    override suspend fun fetchProducts(): Flow<Resource<List<GetProducts>>> {
        return handleResponse.safeApiCall {
            productsService.getProducts()
        }.asResource {
            it.map {
                it.toDomain()
            }
        }
    }
}