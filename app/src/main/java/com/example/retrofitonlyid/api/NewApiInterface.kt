package com.example.retrofitonlyid.api

import com.example.retrofitonlyid.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewApiInterface {
    @GET("top-headlines")
    fun getArticle(
        @Query("country") country : String,
        @Query("category")category: String,
        @Query("apiKey") apiKey : String
    ): Call<News>
}