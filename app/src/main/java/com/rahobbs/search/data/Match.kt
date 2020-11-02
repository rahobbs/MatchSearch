package com.rahobbs.search.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// TODO: add remaining properties need to match spec
@Parcelize
data class Match(val username: String, val cityName: String, val stateName: String, val age: Int) :
    Parcelable