package com.example.exercise_26.presentation.event.home

sealed class HomeEvents {
    data class FetchSuggestions(val title: String) : HomeEvents()
}