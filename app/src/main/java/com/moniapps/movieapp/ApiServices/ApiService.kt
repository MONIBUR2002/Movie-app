package com.moniapps.movieapp.ApiServices

import com.moniapps.movieapp.Models.Movies
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterFace{

    @GET("movielist.json")
    suspend fun getMovies(): List<Movies>

    companion object{
        var apiService:ApiInterFace? = null
        fun getInstance(): ApiInterFace{
            if (apiService == null){
                apiService = Retrofit.Builder().baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiInterFace::class.java)
            }
            return apiService!!
        }
    }
}