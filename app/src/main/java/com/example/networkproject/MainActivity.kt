package com.example.networkproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.networkproject.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            try{
                Log.d("PRODUCTS", "Начинаем запрос")


                val response = RetrofitInstance.api.deleteProduct(17)

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