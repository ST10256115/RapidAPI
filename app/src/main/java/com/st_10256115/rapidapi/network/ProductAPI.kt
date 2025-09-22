package com.st_10256115.rapidapi.network

import retrofit2.http.GET
import retrofit2.http.Query

// Minimal response model — expand as needed from the API's example response
data class ProductItem(
    val title: String?,
    val image: String?,
    val product_link: String?,
    val source: String?
)

data class SearchResponse(
    val status: String?,
    val request_id: String?,
    val data: DataBlock?
)
data class DataBlock(
    val products: List<ProductItem>?
)

interface ProductApi {
    // Example endpoint from the RapidAPI "Code Snippets" tab:
    // GET /search?q=laptop&country=us&language=en
    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("country") country: String = "us",
        @Query("language") language: String = "en"
    ): SearchResponse
}