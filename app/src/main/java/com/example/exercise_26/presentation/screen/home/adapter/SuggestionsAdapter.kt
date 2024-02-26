package com.example.exercise_26.presentation.screen.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_26.databinding.ItemSuggestionLayoutBinding
import com.example.exercise_26.presentation.model.products.Dot
import com.example.exercise_26.presentation.model.products.Products

class SuggestionsAdapter :
    ListAdapter<Products, SuggestionsAdapter.SuggestionsViewHolder>(SuggestionsDiffUtil()) {

    inner class SuggestionsViewHolder(private val binding: ItemSuggestionLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: Products
        fun bind() {
            item = currentList[adapterPosition]
            with(binding) {
                tvTitle.text = item.name

                tvNumberOfParents.text = item.numberOfParents.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SuggestionsViewHolder(
        ItemSuggestionLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: SuggestionsViewHolder, position: Int) {
        holder.bind()
    }

    class SuggestionsDiffUtil : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem == newItem
        }
    }
}