package com.example.exercise_26.data.mapper.products

import com.example.exercise_26.domain.model.product.GetProducts
import com.example.exercise_26.data.model.product.ProductsDto

fun ProductsDto.toDomain() :GetProducts = GetProducts(
    bglNumber =bglNumber,
    bglVariant =bglVariant,
    children = children.map {
        it.toDomain()
    },
    createdAt = createdAt,
    id = id,
    main = main,
    name = name,
    nameDe = nameDe,
    orderId = orderId

)

