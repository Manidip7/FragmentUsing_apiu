package com.example.fragmentusing_api.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentusing_api.repostory.fackRepostory

class mainViewModelFactory (private val repostory: fackRepostory) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repostory) as T
    }
}