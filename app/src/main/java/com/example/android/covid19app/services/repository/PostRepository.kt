package com.example.android.covid19app.services.repository

import com.example.android.covid19app.services.api.RetrofitInstance
import com.example.android.covid19app.services.model.Post
import retrofit2.Response

class PostRepository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.postApi.getPost()
    }

    suspend fun getPostById(postId: Int): Response<Post> {
        return RetrofitInstance.postApi.getPostById(postId)
    }

    suspend fun getPostByUserId(userId: Int): Response<List<Post>> {
        return RetrofitInstance.postApi.getPostByUserId(userId)
    }
}