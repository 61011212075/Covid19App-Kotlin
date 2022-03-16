package com.example.android.covid19app.services.api

import com.example.android.covid19app.services.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postId}")
    suspend fun getPostById(
        @Path("postId") number: Int
    ):Response<Post>

    @GET("posts")
    suspend fun getPostByUserId(
        @Query("userId") userId: Int
    ):Response<List<Post>>
}