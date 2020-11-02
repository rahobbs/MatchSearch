package com.rahobbs.search.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.rahobbs.search.data.MatchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.okcupid.com"

private val gson =
    GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

interface MatchApiService {
    @GET("/matchSample.json")
    fun getMatchesAsync(): Call<MatchResponse>
}

object MatchApi {
    val retrofitService: MatchApiService by lazy {
        retrofit.create(MatchApiService::class.java)
    }
}