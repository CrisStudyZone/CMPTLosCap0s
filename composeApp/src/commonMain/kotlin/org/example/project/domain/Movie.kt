package org.example.project.domain

data class Movie(
    val id: Int,
    val title: String,
    val overview: String? = null,
    val voteAverage: Double? = null,
    val voteCount: Int? = null,
    val popularity: Double? = null,
    val adult:Boolean? = null,
    val description: String,
    val posterUrl: String,
    val backdropUrl: String,
    val rating: Double,
    val releaseDate: String
)