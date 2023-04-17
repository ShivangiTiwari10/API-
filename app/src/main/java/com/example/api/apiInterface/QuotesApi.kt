package com.example.api.apiInterface

import com.example.api.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}