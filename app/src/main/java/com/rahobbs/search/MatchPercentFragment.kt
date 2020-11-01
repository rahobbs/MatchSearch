package com.rahobbs.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahobbs.search.databinding.MatchPercentFragmentBinding

class MatchPercentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MatchPercentFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}