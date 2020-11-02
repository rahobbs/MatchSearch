package com.rahobbs.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahobbs.search.databinding.SpecialBlendFragmentBinding

class SpecialBlendFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = SpecialBlendFragmentBinding.inflate(inflater, container, false)

        val adapter = PersonCardAdapter()
        binding.specialBlendList.adapter = adapter

        adapter.submitList(listOf("Jim", "Bob", "Tom"))

        return binding.root
    }
}