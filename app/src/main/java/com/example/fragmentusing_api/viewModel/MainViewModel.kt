package com.example.fragmentusing_api.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentusing_api.model.FackData
import com.example.fragmentusing_api.repostory.fackRepostory
import com.example.fragmentusing_api.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repostory: fackRepostory):ViewModel() {

    fun getFackData(postId:Int) = viewModelScope.launch (Dispatchers.IO){
        repostory.getFackData(postId)
    }

    val Fack:LiveData<NetworkResult<FackData>>
        get() = repostory._Fack
}