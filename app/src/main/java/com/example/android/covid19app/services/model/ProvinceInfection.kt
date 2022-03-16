package com.example.android.covid19app.services.model

import com.google.gson.annotations.SerializedName

data class ProvinceInfection (
    @SerializedName("txn_date")
    val date: String,

    @SerializedName("province")
    val province: String,

    @SerializedName("new_case")
    val newCase: Int,

    @SerializedName("total_case")
    val totalCase: Int,

    @SerializedName("new_case_excludeabroad")
    val newCaseExcludeAbroad: Int,

    @SerializedName("total_case_excludeabroad")
    val totalCaseExcludeAbroad: Int,

    @SerializedName("new_death")
    val newDeath: Int,

    @SerializedName("total_death")
    val totalDeath: Int,

    @SerializedName("update_date")
    val updateDate: String
)

