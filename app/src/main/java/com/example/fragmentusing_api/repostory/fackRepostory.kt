package com.example.fragmentusing_api.repostory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fragmentusing_api.api.ApiServices
import com.example.fragmentusing_api.model.FackData
import com.example.fragmentusing_api.util.NetworkResult

class fackRepostory(private val apiServices: ApiServices) {

    private val FackLiveData = MutableLiveData<NetworkResult<FackData>>()
    val _Fack : LiveData<NetworkResult<FackData>>
        get() = FackLiveData

    suspend fun getFackData(postId :Int){
        FackLiveData.postValue(NetworkResult.Loading())
        val result = apiServices.getFackData(postId)

        if (result.isSuccessful && result.body() != null){
            FackLiveData.postValue(NetworkResult.Success(result.body()))
        }else if (result.errorBody() != null){
            FackLiveData.postValue(NetworkResult.Error("Somthing went wrong"))
        }else{
            FackLiveData.postValue(NetworkResult.Error("Somthing went wrong"))
        }
    }
}