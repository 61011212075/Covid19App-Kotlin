package com.example.android.covid19app.services.model

import com.google.gson.annotations.SerializedName

data class OverallInfection(
    @SerializedName("txn_date")
    val date: String,

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

    @SerializedName("new_recovered")
    val newRecovered: Int,

    @SerializedName("total_recovered")
    val totalRecovered: Int,

    @SerializedName("update_date")
    val updateDate: String
)

//{
//    "txn_date": "2022-03-12",
//    "new_case": 24592,
//    "total_case": 3161241,
//    "new_case_excludeabroad": 24540,
//    "total_case_excludeabroad": 3139685,
//    "new_death": 68,
//    "total_death": 23643,
//    "new_recovered": 21371,
//    "total_recovered": 2911447,
//    "update_date": "2022-03-12 07:22:08"
//}