package com.example.playgroundmoviesapp.usecase

import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class AuthenticateUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): Unit = movieRepository.authenticate()
}
