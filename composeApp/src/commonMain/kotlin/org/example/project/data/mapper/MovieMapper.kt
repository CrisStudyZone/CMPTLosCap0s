package org.example.project.data.mapper

import org.example.project.data.model.response.MovieDto
import org.example.project.domain.Movie

fun MovieDto.toDomain(): Movie {
    val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
    val backdropBaseUrl = "https://image.tmdb.org/t/p/w780"

    return Movie(
        id = id,
        title = title,
        description = overview.ifEmpty { "Sin descripción disponible" },
        posterUrl = if (posterPath != null) "$posterBaseUrl$posterPath" else "",
        backdropUrl = if (backdropPath != null) "$backdropBaseUrl$backdropPath" else "",
        rating = voteAverage,
        releaseDate = releaseDate ?: "",
        overview = overview,
        voteAverage = voteAverage,
        voteCount = voteCount,
        popularity = popularity,
        adult = adult,
    )
}