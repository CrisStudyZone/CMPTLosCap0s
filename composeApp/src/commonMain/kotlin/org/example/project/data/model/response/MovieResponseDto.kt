package org.example.project.data.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    @SerialName("page") val page: Int,
    @SerialName("results") val results: List<MovieDto>,
    @SerialName("total_pages") val totalPages: Int,
    @SerialName("total_results") val totalResults: Int
)