package com.example.data.mapper

import com.example.data.service.api.response.MovieDetailsResponse
import com.example.domain.entity.MovieDetails
import javax.inject.Inject

internal class MovieDetailsResponseToMovieDetailsMapper @Inject constructor() :
    BaseResponseMapper<MovieDetailsResponse, MovieDetails> {

    // TODO: Update transform method after updating MovieDetails parameters
    override suspend fun transform(input: MovieDetailsResponse?) =
        MovieDetails(
            title = input?.originalTitle.orEmpty()
        )
}
