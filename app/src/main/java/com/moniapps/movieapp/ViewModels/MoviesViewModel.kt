package com.moniapps.movieapp.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moniapps.movieapp.ApiServices.ApiInterFace
import com.moniapps.movieapp.Models.Movies
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    var movieListResponse: List<Movies> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getMovieList(){
        viewModelScope.launch {
            val apiService = ApiInterFace.getInstance()
            try {
                val moviesList = apiService.getMovies()
                movieListResponse = moviesList
            }
            catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}