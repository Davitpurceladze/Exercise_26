package com.example.exercise_26.data.service.home

import com.example.exercise_26.data.model.product.ProductsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsService {
    @GET("6f722f19-3297-4edd-a249-fe765e8104db")
    suspend fun getProducts() : Response<List<ProductsDto>>
}