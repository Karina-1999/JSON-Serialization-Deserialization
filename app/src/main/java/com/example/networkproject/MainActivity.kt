package com.example.networkproject

import android.R.attr.description
import android.os.Bundle
import android.util.Log
import android.util.Log.e
import androidx.appcompat.app.AppCompatActivity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Serializable
data class Product (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String = ""
)

@Serializable
data class UpdateProduct(
    val title: String,
    val price: Double,
    val description: String = ""
)

@Serializable
data class ProductsResponse(
    val products: List<Product>
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val json = Json{
            ignoreUnknownKeys = true
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()


        val productApi = retrofit.create(ProductApi::class.java)
        lifecycleScope.launch {
            try{
                Log.d("PRODUCTS", "Начинаем запрос")

                val newProduct = Product(
                    id = 0,
                    title = "My Product",
                    price = 4.67,
                    description = "My First Product"
                )

                val upProduct = UpdateProduct(
                    title = "appLE",
                    price = 999.999,
                    description = "I change this product"
                )
                val response = productApi.updateProduct(17, upProduct)

                Log.d("PRODUCTS", "Получили ответ")
                Log.d("PRODUCTS", response.toString())
            }
                catch (e: Exception) {
                    Log.e("PRODUCTS", "Тип ошибки: ${e::class.simpleName}")
                    Log.e("PRODUCTS", "Сообщение: ${e.message}")
                    e.printStackTrace()
                }

        }
    }
}