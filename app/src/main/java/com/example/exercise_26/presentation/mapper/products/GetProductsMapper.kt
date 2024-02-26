package com.example.exercise_26.presentation.mapper.products

import com.example.exercise_26.domain.model.product.GetProducts
import com.example.exercise_26.presentation.model.products.Products

fun GetProducts.toPresenter() = Products(
    children = children.map {
        it
    },
    id = id,
    name = name,
numberOfParents = numberOfParents
    )
