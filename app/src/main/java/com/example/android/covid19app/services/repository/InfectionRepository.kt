package com.example.android.covid19app.services.repository

import com.example.android.covid19app.services.api.RetrofitInstance
import com.example.android.covid19app.services.model.OverallInfection
import com.example.android.covid19app.services.model.ProvinceInfection

import retrofit2.Response

class InfectionRepository {

    suspend fun getOverallInfection(): Response<List<OverallInfection>>{
        return RetrofitInstance.infectionApi.getOverallInfection()
    }

    suspend fun getProvinceInfection(): Response<List<ProvinceInfection>>{
        return RetrofitInstance.infectionApi.getProvinceInfection()
    }

}