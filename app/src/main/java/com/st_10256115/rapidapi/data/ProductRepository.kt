package com.st_10256115.rapidapi.data


import com.st_10256115.products.network.NetworkModule
import com.st_10256115.products.network.ProductItem

class ProductRepository {
    private val api = NetworkModule.retrofit.create(com.example.products.network.ProductApi::class.java)
    suspend fun search(q: String): List<ProductItem> =
        api.search(q).data?.products ?: emptyList()
}