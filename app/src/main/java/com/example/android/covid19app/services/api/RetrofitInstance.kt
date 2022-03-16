package com.example.android.covid19app.services.api

import com.example.android.covid19app.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofitCovid by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.COVID_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val retrofitPost by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.POST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val infectionApi: InfectionApi by lazy {
        retrofitCovid.create(InfectionApi::class.java)
    }

    val postApi: PostApi by lazy {
        retrofitPost.create(PostApi::class.java)
    }
}