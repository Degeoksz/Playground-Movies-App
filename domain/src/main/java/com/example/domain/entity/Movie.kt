package com.example.domain.entity

import java.time.Instant
import java.util.Date

// TODO: Add missing parameters into constructor
data class Movie(
    val id: Int = 0,
    val title: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val posterUrl: String = "",
    val releaseDate: Date = Date.from(Instant.MIN),
    val voteAverage: Float = 0.0f,
    val voteCount: Int = 0
)
