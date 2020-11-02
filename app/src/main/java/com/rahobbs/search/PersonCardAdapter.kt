package com.rahobbs.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahobbs.search.databinding.PersonCardViewBinding

class PersonCardAdapter : ListAdapter<String, RecyclerView.ViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardViewHolder(
            PersonCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val string = getItem(position)
        (holder as CardViewHolder).bind(string)
    }

    class CardViewHolder(private val binding: PersonCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(string: String) {
            binding.userNameView.text = string
        }
    }

    class CardDiffCallback : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
