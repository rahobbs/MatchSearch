package com.rahobbs.search.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        const val SPECIAL_BLEND = 0
        const val MATCH_PERCENT = 1
    }

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        SPECIAL_BLEND to { SpecialBlendFragment() },
        MATCH_PERCENT to { MatchPercentFragment() }
    )


    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}