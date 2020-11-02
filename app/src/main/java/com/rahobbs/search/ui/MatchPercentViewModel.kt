package com.rahobbs.search.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahobbs.search.data.Match
import com.rahobbs.search.data.MatchResponseRepository
import kotlinx.coroutines.launch

class MatchPercentViewModel : ViewModel() {
//
//    Special Blend
//    The "Special Blend" tab will show all the people that come from the endpoint in a grid as shown in the mockup. A user of the app should be able
//    to tap one of the cards to simulate a "like" action. This will cause the associated card that was tapped to be highlighted yellow. Please see the
//    second screenshot below for what this should look like. A user should also be able tap a "liked" person to "unlike" them. This will remove the
//    yellow highlight from the card.
//
//    Match %
//    In addition to highlighting the card, "liking" a person also will send that person to the "Match %" tab. When a user swipes to the "Match %" tab,
//    they will see the top 6 people who are "liked" sorted by Match %. When a person is "unliked", they should be removed from the "Match %" page

    private val matchResponseRepository by lazy { MatchResponseRepository() }

    private val _matchesList = MutableLiveData<List<Match>>()
    val matchesList: LiveData<List<Match>>
        get() = _matchesList

    init {
        fetchAllMatches()
    }

    private fun fetchAllMatches() {
        viewModelScope.launch {
            _matchesList.value = matchResponseRepository.getAllMatches()
        }
    }
}