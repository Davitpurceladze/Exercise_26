package com.example.exercise_26.presentation.model.products

import com.example.exercise_26.domain.model.product.GetProducts

data class Products (


    val children: List<GetProducts>,

    val id: String,

    val name: String,

    val numberOfParents: Int
)