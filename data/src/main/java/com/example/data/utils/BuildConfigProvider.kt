package com.example.data.utils

import com.example.data.BuildConfig
import javax.inject.Inject

class BuildConfigProvider @Inject constructor() {
    fun getApiUrl(): String = BuildConfig.API_URL
    fun getApiKey(): String = BuildConfig.API_KEY
    fun getPosterUrl(): String = BuildConfig.POSTER_URL
}
