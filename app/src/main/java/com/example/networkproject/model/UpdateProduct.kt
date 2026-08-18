package com.example.networkproject.model

import kotlinx.serialization.Serializable

@Serializable
data class UpdateProduct(
    val title: String,
    val price: Double,
    val description: String = ""
)