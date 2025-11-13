package org.example.project.data.source.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.project.data.model.response.MovieDto
import org.example.project.data.model.response.MovieResponseDto

class ApiService(private val client: HttpClient) {

    private val baseUrl = "https://api.themoviedb.org/3"
    private val apiKey =
        "94011cc9a01863e25b6a7a02bf6e6358" // TODO: poner esto en local.properties más adelante

    suspend fun getPopularMovies(): MovieResponseDto {
        return client.get("$baseUrl/movie/popular") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
        }.body()
    }


    suspend fun getTopRatedMovies(): MovieResponseDto {
        return client.get("$baseUrl/movie/top_rated") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
        }.body()
    }

    suspend fun getUpcomingMovies(): MovieResponseDto {
        return client.get("$baseUrl/movie/upcoming") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
        }.body()
    }

    suspend fun searchMovies(query: String): MovieResponseDto {
        return client.get("$baseUrl/search/movie") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
            parameter("query", query)
        }.body()
    }

    suspend fun getMovieDetails(movieId: Int): MovieDto {
        return client.get("$baseUrl/movie/$movieId") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
        }.body()
    }

    suspend fun getMoviesByGenre(genreId: Int, page: Int = 1): MovieResponseDto {
        return client.get("$baseUrl/discover/movie") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
            parameter("with_genres", genreId) // ID del género (ej. 28 para Acción)
            parameter("page", page) // Para paginación
        }.body()
    }

    suspend fun getRecommendations(movieId: Int): MovieResponseDto {
        return client.get("$baseUrl/movie/$movieId/recommendations") {
            parameter("api_key", apiKey)
            parameter("language", "es-ES")
        }.body()
    }

    // "day" o "week"
    suspend fun getTrendingMovies(timeWindow: String = "day"): MovieResponseDto {
        return client.get("$baseUrl/trending/movie/$timeWindow") {
            parameter("api_key", apiKey)
        }.body()
    }
}