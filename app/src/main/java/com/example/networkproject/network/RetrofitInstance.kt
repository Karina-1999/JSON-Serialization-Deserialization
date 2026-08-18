package com.example.networkproject.network

import com.example.networkproject.api.ProductApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object RetrofitInstance {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val api: ProductApi = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(ProductApi::class.java)
}