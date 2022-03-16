package com.example.android.covid19app.services.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.covid19app.services.model.OverallInfection
import com.example.android.covid19app.services.model.ProvinceInfection
import com.example.android.covid19app.services.repository.InfectionRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class InfectionViewModel(private val repository: InfectionRepository): ViewModel() {

    val listOverallInfection: MutableLiveData<Response<List<OverallInfection>>> = MutableLiveData()
    val listProvinceInfection: MutableLiveData<Response<List<ProvinceInfection>>> = MutableLiveData()

    fun getOverallInfection(){
        viewModelScope.launch {
            val response = repository.getOverallInfection()
            listOverallInfection.value = response
        }
    }

    fun getProvinceInfection(){
        viewModelScope.launch {
            val response = repository.getProvinceInfection()
            listProvinceInfection.value = response
        }
    }

}

class InfectionViewModelFactory(private val repository: InfectionRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfectionViewModel(repository) as T
    }

}

