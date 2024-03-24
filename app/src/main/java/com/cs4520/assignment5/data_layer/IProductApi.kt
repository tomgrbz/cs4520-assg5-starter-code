package com.cs4520.assignment5.data_layer


import com.cs4520.assignment5.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit methods container
 */
interface IProductApi {

    @GET(Api.ENDPOINT)
    suspend fun getProducts(@Query("page") pageNumber: Int?): Response<List<Product>>
}