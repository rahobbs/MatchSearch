package com.rahobbs.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rahobbs.search.databinding.MatchPercentFragmentBinding

class MatchPercentFragment : Fragment() {

    private val viewModel: MatchPercentViewModel by lazy {
        ViewModelProvider(this).get(MatchPercentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MatchPercentFragmentBinding.inflate(inflater, container, false)

        val adapter = PersonCardAdapter()
        binding.matchPercentList.adapter = adapter

        viewModel.topLikesList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }
}