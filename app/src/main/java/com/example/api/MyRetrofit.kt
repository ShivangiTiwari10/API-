package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api.`interface`.MyApiInterface
import com.example.api.databinding.ActivityMyRetrofitBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit : AppCompatActivity() {
    private lateinit var binding: ActivityMyRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
            .create(MyApiInterface::class.java)
    }
}