package com.example.fragmentusing_api

import android.app.Application
import com.example.fragmentusing_api.api.ApiServices
import com.example.fragmentusing_api.api.RetrofitHelper
import com.example.fragmentusing_api.repostory.fackRepostory

class FackApplication :Application(){

    lateinit var fackRepostory: fackRepostory
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val fackServices = RetrofitHelper.getInstance().create(ApiServices::class.java)
        fackRepostory = fackRepostory(fackServices)
    }
}