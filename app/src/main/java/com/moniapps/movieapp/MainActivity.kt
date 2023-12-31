package com.moniapps.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.moniapps.movieapp.Models.Movies
import com.moniapps.movieapp.ViewModels.MoviesViewModel
import com.moniapps.movieapp.ViewsF.MoiveItem
import com.moniapps.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    private val moviesViewModel by viewModels<MoviesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    moviesViewModel.getMovieList()
                    MovieList(movieList = moviesViewModel.movieListResponse)
                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movies>) {
    LazyColumn {
        itemsIndexed(items = movieList) { _, item ->
            MoiveItem(movies = item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        val movie1 = Movies("Drama", "gjjjhvhjhvjhv", "", "Jaws")
        MoiveItem(movies = movie1)
    }
}