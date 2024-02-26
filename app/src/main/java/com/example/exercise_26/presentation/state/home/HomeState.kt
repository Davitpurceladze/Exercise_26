package com.example.exercise_26.presentation.state.home

import com.example.exercise_26.presentation.model.products.Products

data class HomeState (
   val filteredProducts: List<Products>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)