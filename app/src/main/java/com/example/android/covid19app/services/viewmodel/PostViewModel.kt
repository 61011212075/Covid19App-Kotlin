package com.example.android.covid19app.services.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.android.covid19app.services.model.Post
import com.example.android.covid19app.services.repository.PostRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: PostRepository): ViewModel()  {

    val postResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val listPostResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            postResponse.value = response
        }
    }

    fun getPostById(postId: Int){
        viewModelScope.launch {
            val response = repository.getPostById(postId)
            postResponse.value = response
        }
    }

    fun getPostByUserId(userId: Int){
        viewModelScope.launch {
            val response = repository.getPostByUserId(userId)
            listPostResponse.value = response
        }
    }
}

class PostViewModelFactory(private val repository: PostRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }
}