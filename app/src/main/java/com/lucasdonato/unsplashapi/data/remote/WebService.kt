package com.lucasdonato.unsplashapi.data.remote

import com.lucasdonato.unsplashapi.BuildConfig
import com.lucasdonato.unsplashapi.data.model.SearchResult
import com.lucasdonato.unsplashapi.data.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WebService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
    ): SearchResult

}