package org.example.project.domain.repository

import org.example.project.data.core.NetworkResult
import org.example.project.data.model.response.MovieResponseDto
import org.example.project.domain.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): NetworkResult<List<Movie>>
    suspend fun getTopRatedMovies(): NetworkResult<List<Movie>>
    suspend fun getUpcomingMovies(): NetworkResult<List<Movie>>
    suspend fun searchMovies(query: String): NetworkResult<List<Movie>>
    suspend fun getMovieDetails(id: Int): NetworkResult<Movie>

    suspend fun getMoviesByGenre(genreId: Int, page: Int = 1): NetworkResult<List<Movie>>

    suspend fun getRecommendations(movieId: Int): NetworkResult<List<Movie>>

    suspend fun getTrendingMovies(timeWindow: String = "day"): NetworkResult<List<Movie>>
}