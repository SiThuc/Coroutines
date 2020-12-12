package com.example.coroutinesretrofit.model

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)