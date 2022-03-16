package com.example.android.covid19app.services.api

import com.example.android.covid19app.services.model.OverallInfection
import com.example.android.covid19app.services.model.ProvinceInfection
import retrofit2.Response
import retrofit2.http.GET

interface InfectionApi {

    @GET("api/Cases/today-cases-all")
    suspend fun getOverallInfection(): Response<List<OverallInfection>>

    @GET("api/Cases/today-cases-by-provinces")
    suspend fun getProvinceInfection(): Response<List<ProvinceInfection>>

}