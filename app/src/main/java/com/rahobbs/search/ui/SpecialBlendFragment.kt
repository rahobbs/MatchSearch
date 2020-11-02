package com.rahobbs.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rahobbs.search.databinding.SpecialBlendFragmentBinding

class SpecialBlendFragment : Fragment() {

    private val viewModel: MatchPercentViewModel by lazy {
        ViewModelProvider(this).get(MatchPercentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = SpecialBlendFragmentBinding.inflate(inflater, container, false)

        val adapter = PersonCardAdapter()
        binding.specialBlendList.adapter = adapter

        viewModel.matchesList.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        return binding.root
    }
}