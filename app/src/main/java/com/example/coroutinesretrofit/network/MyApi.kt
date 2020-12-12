package com.example.coroutinesretrofit.network

import com.example.coroutinesretrofit.model.Movie
import com.example.coroutinesretrofit.model.QuotesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
    @GET("mvvm/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    @GET("recyclerview/movies")
    suspend fun getMovies(): Response<List<Movie>>

    companion object{
        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/")
                .build()
                .create(MyApi::class.java)
        }
    }
}