package com.rahobbs.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahobbs.search.data.Match
import com.rahobbs.search.data.MatchResponseRepository
import kotlinx.coroutines.launch

class MatchPercentViewModel : ViewModel() {
    private val matchResponseRepository by lazy { MatchResponseRepository() }

    private val _matchesList = MutableLiveData<List<Match>>()
    val matchesList: LiveData<List<Match>>
        get() = _matchesList

    private val _topLikesList = MutableLiveData<List<Match>>()
    val topLikesList: LiveData<List<Match>>
        get() = _topLikesList
    init {
        fetchAllMatches()
    }

    private fun fetchAllMatches() {
        viewModelScope.launch {
            val allMatches = matchResponseRepository.getAllMatches()
            _matchesList.value = allMatches

            // TODO: replace sort by 'age' with sort by 'matchPercent'
            _topLikesList.value = allMatches.sortedByDescending { it.age }.subList(0, 6)
        }
    }
}