package com.rahobbs.search.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahobbs.search.R
import com.rahobbs.search.data.Match
import com.rahobbs.search.databinding.PersonCardViewBinding

class PersonCardAdapter(private val clickListener: OnClickListener) :
    ListAdapter<Match, RecyclerView.ViewHolder>(CardDiffCallback()) {


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

        if (match != null) {
            (holder as CardViewHolder).bind(match)
            holder.itemView.setOnClickListener {
                clickListener.onClick(match)
            }
        }
    }

    class CardViewHolder(private val binding: PersonCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(match: Match) {

            Glide.with(binding.root.context)
                .load(match.photo.thumbPaths.large)
                .placeholder(R.drawable.ic_baseline_person_outline_40)
                .into(binding.profilePicView)

            binding.userNameView.text = match.username
            binding.ageAndLocation.text = // TODO: format with with a StringUtil
                "${match.age}-${match.cityName},${match.stateName}"
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

    class OnClickListener(val clickListener: (match: Match) -> Unit) {
        fun onClick(match: Match) = clickListener(match)
    }
}
