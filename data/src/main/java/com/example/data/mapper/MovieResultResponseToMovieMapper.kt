package com.example.data.mapper

import com.example.data.utils.BuildConfigProvider
import com.example.data.service.api.response.MovieResponse
import com.example.data.utils.DateParser
import com.example.domain.entity.Movie
import javax.inject.Inject

internal class MovieResultResponseToMovieMapper @Inject constructor(
    private val dateParser: DateParser,
    private val buildConfigProvider: BuildConfigProvider
) : BaseResponseMapper<MovieResponse, Movie> {
    // TODO: Update transform method after updating Movie parameters
    override suspend fun transform(input: MovieResponse?) =
        Movie(
            id = input?.id ?: 0,
            title = input?.title.orEmpty(),
            originalTitle = input?.originalTitle.orEmpty(),
            overview = input?.overview.orEmpty(),
            posterUrl = buildConfigProvider.getPosterUrl() + input?.posterPath.orEmpty(),
            releaseDate = dateParser.converseDateFromStringToDate(input?.releaseDate),
            voteAverage = input?.voteAverage ?: 0.0f,
            voteCount = input?.voteCount ?: 0
        )
}
