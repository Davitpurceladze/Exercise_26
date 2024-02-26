package com.example.exercise_26.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exercise_26.data.common.Resource
import com.example.exercise_26.domain.usecase.products.FilterProductsUseCase
import com.example.exercise_26.presentation.event.home.HomeEvents
import com.example.exercise_26.presentation.mapper.products.toPresenter
import com.example.exercise_26.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val filterProductsUseCase: FilterProductsUseCase
): ViewModel() {

    private val _productsState = MutableStateFlow(HomeState())
    val productsState: SharedFlow<HomeState> = _productsState.asStateFlow()

    fun onEvent(event: HomeEvents) {
        when(event) {
            is HomeEvents.FetchSuggestions -> fetchSuggestions(filter = event.title)
        }
    }

    private fun fetchSuggestions(filter: String) {
        viewModelScope.launch {
            filterProductsUseCase(filter).collect{
                when (it) {
                    is Resource.Success -> _productsState.update {currentState ->
                        currentState.copy(
                            filteredProducts = it.data.map {
                                it.toPresenter()
                            }
                        )
                    }

                    is Resource.Error -> _productsState.update { currentState ->
                        currentState.copy(
                            errorMessage = it.errorMessage
                        )
                    }

                    is Resource.Loading -> _productsState.update { currentState ->
                        currentState.copy(
                            isLoading = it.loading
                        )
                    }
                }
            }
        }
    }
}