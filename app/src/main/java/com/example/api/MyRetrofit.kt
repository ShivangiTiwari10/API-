package com.example.api

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.`interface`.MyApiInterface
import com.example.api.databinding.ActivityMyRetrofitBinding
import com.example.api.mydataClass.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofit : AppCompatActivity() {
    private lateinit var binding: ActivityMyRetrofitBinding
    private lateinit var myadapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressDialog = ProgressDialog(this@MyRetrofit)
        progressDialog.setTitle("Progress Bar")
        progressDialog.setMessage("Application is loading, please wait")
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory((GsonConverterFactory.create()))
            .build()
            .create(MyApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()
        progressDialog.show()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                progressDialog.dismiss()

                ////               if api call is success, then use the data of api and show in your app
                val responceBody = response.body()
                val productList = responceBody?.products
                myadapter = MyAdapter(this@MyRetrofit, productList!!)
                binding.myRecycler.adapter = myadapter
                binding.myRecycler.layoutManager = LinearLayoutManager(this@MyRetrofit)


            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                ////                if api call fails
//
                Log.d("MyRetrofitActivity", "onFailure ${t.message}")

            }
        })
    }
}




