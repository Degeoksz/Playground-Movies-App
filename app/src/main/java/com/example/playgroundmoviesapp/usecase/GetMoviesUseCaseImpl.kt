package com.example.playgroundmoviesapp.usecase

import com.example.domain.entity.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.GetMoviesUseCase
import com.example.domain.usecase.MovieListType
import com.example.playgroundmoviesapp.di.DISPATCHERS_IO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class GetMoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    @Named(DISPATCHERS_IO) private val dispatcher: CoroutineDispatcher
) : GetMoviesUseCase {
    override suspend fun invoke(movieListType: MovieListType): List<Movie> =
        withContext(dispatcher) {
            when (movieListType) {
                MovieListType.ToDiscover -> movieRepository.getToDiscoverMovies()
                MovieListType.NowPlaying -> movieRepository.getNowPlayingMovies()
                MovieListType.Popular -> movieRepository.getPopularMovies()
                MovieListType.TopRated -> movieRepository.getTopRatedMovies()
                MovieListType.Upcoming -> movieRepository.getUpcomingMovies()
            }
        }
}
