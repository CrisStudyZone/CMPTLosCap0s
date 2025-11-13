package org.example.project.data.repository

import org.example.project.data.core.NetworkResult
import org.example.project.data.mapper.toDomain
import org.example.project.data.source.remote.ApiService
import org.example.project.domain.Movie
import org.example.project.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val apiService: ApiService,
) : MovieRepository {

    override suspend fun getPopularMovies(): NetworkResult<List<Movie>> {
        return try {
            val responseDto = apiService.getPopularMovies()

            val moviesDomain = responseDto.results.map { it.toDomain() }

            NetworkResult.Success(moviesDomain)

        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error("Error al cargar películas: ${e.message}")
        }
    }

    override suspend fun getTopRatedMovies(): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getTopRatedMovies()
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun getUpcomingMovies(): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getUpcomingMovies()
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun searchMovies(query: String): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.searchMovies(query)
            NetworkResult.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun getMovieDetails(id: Int): NetworkResult<Movie> {
        return try {
            val response = apiService.getMovieDetails(id)
            NetworkResult.Success(response.toDomain())
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Error desconocido")
        }
    }

    override suspend fun getMoviesByGenre(
        genreId: Int,
        page: Int,
    ): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getMoviesByGenre(genreId, page)
            val moviesDomain = response.results.map { it.toDomain() }
            NetworkResult.Success(moviesDomain)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error(e.message ?: "Error al cargar por género.")
        }
    }

    override suspend fun getRecommendations(movieId: Int): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getRecommendations(movieId)
            val moviesDomain = response.results.map { it.toDomain() }
            NetworkResult.Success(moviesDomain)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error(e.message ?: "Error al cargar recomendaciones.")
        }
    }

    override suspend fun getTrendingMovies(timeWindow: String): NetworkResult<List<Movie>> {
        return try {
            val response = apiService.getTrendingMovies(timeWindow)
            val moviesDomain = response.results.map { it.toDomain() }
            NetworkResult.Success(moviesDomain)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkResult.Error(e.message ?: "Error al cargar tendencias.")
        }
    }
}


