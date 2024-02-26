package com.example.exercise_26.data.model.product

import com.squareup.moshi.Json

data class ProductsDto(
    @Json(name = "bgl_number")
    val bglNumber: String?,
    @Json(name = "bgl_variant")
    val bglVariant: String?,
    val children: List<ProductsDto>,
    val createdAt: String,
    val id: String,
    val main: String?,
    val name: String,
    @Json(name = "name_de")
    val nameDe: String,
    @Json(name = "order_id")
    val orderId: Int?
)