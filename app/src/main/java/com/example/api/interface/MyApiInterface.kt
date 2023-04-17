package com.example.api.`interface`

import com.example.api.mydataClass.MyData
import retrofit2.Call
import retrofit2.http.GET

interface MyApiInterface {
    @GET("products")
    fun getProductData(): Call<MyData>
}