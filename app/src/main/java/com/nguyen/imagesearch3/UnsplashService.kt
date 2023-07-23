package com.nguyen.imagesearch3

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY

interface UnsplashService {
    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(@Query("query") query: String, @Query("page") page: Int, @Query("per_page") perPage: Int): Data
}