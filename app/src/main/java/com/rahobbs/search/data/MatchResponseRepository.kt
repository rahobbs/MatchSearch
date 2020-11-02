package com.rahobbs.search.data

import com.rahobbs.search.api.MatchApi
import retrofit2.await

class MatchResponseRepository() {

    suspend fun getAllMatches(): List<Match> {
        return MatchApi.retrofitService.getMatchesAsync().await().data
    }
}