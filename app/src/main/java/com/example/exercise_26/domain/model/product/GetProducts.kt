package com.example.exercise_26.domain.model.product

data class GetProducts(
    val bglNumber: String?,
    val bglVariant: String?,
    val children: List<GetProducts>,
    val createdAt: String,
    val id: String,
    val main: String?,
    val name: String,
    val nameDe: String,
    val orderId: Int?,
    val numberOfParents: Int = 0
)