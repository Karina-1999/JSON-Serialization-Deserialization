package com.example.networkproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Product (
    val id: Int,
    val title: String,
    val price: Double
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product = Product(
            id = 7,
            title = "MacBook Pro",
            price = 2499.99
        )
        val json = Json.encodeToString(product)
        println(json)

        val restoredProduct = Json.decodeFromString<Product>(json)

        println(restoredProduct.title)
        println(restoredProduct.price)
    }
}