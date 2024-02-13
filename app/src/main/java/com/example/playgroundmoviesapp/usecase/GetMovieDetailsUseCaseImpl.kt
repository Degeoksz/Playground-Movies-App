package com.example.playgroundmoviesapp.usecase

import com.example.domain.entity.MovieDetails
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.GetMovieDetailsUseCase
import com.example.playgroundmoviesapp.di.DISPATCHERS_IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class GetMovieDetailsUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    @Named(DISPATCHERS_IO) private val dispatcher: CoroutineDispatcher
): GetMovieDetailsUseCase {
    override suspend fun invoke(id: Int): MovieDetails = withContext(dispatcher) {
        movieRepository.getMovieDetails(id)
    }
}