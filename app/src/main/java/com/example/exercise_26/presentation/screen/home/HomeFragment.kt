package com.example.exercise_26.presentation.screen.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise_26.databinding.FragmentHomeBinding
import com.example.exercise_26.presentation.base.BaseFragment
import com.example.exercise_26.presentation.event.home.HomeEvents
import com.example.exercise_26.presentation.screen.home.adapter.SuggestionsAdapter
import com.example.exercise_26.presentation.state.home.HomeState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeFragmentViewModel by viewModels()
    private lateinit var suggestionsAdapter: SuggestionsAdapter


    override fun bind() {
        with(binding.suggestionsRecycler) {
            suggestionsAdapter = SuggestionsAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            adapter =suggestionsAdapter
        }
        viewModel.onEvent(HomeEvents.FetchSuggestions("cranes"))
    }

    override fun bindViewActionListeners() {
    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.productsState.collect{
                    handleHomeState(it)
                }
            }
        }
    }

    private fun handleHomeState(state: HomeState) {
        state.filteredProducts?.let {
            suggestionsAdapter.submitList(it)
        }
    }
}