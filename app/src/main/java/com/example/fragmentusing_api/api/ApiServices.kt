package com.example.fragmentusing_api.api

import com.example.fragmentusing_api.model.FackData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

     @GET("/comments")
     suspend fun getFackData(
         @Query ("postId") postId:Int
     ):Response<FackData>

}