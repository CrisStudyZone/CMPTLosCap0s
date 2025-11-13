package org.example.project.ui.screen.login.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.data.core.NetworkResult
import org.example.project.domain.repository.MovieRepository

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {



    fun fetchPopularMovies() {
        viewModelScope.launch {
            when (val result = repository.getPopularMovies()) {
                is NetworkResult.Success -> {

                    println(result.data)
                }
                is NetworkResult.Error -> {

                    println(result.message)
                }
                is NetworkResult.Loading -> {
                }
            }
        }
    }


}