package com.example.api.model

data class QuoteList(

    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val totalCount: Int,
    val totalPages: Int
)
