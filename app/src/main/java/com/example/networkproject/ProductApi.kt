package com.example.networkproject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductsResponse

    @GET("products/{productId}")
    suspend fun getProduct(
        @Path("productId") id: Int
    ): Product

    @GET("products")
    suspend fun getLimitProduct(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): ProductsResponse

    @POST ("products/add")
    suspend fun createPrpduct(
        @Body product: Product
    ): Product
}