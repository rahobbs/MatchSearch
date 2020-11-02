package com.rahobbs.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rahobbs.search.data.Match
import com.rahobbs.search.databinding.PersonCardViewBinding

class PersonCardAdapter : ListAdapter<Match, RecyclerView.ViewHolder>(CardDiffCallback()) {
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
        val match = getItem(position)
        (holder as CardViewHolder).bind(match.username)
    }

    class CardViewHolder(private val binding: PersonCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(string: String) {
            binding.userNameView.text = string
        }
    }

    class CardDiffCallback : DiffUtil.ItemCallback<Match>() {

        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            // TODO: compare on Ids
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem == newItem
        }
    }
}
