package com.cs4520.assignment5.application

import android.content.Context
import androidx.room.Room
import com.cs4520.assignment5.data_layer.Api
import com.cs4520.assignment5.data_layer.LocalDatabase
import com.cs4520.assignment5.data_layer.ProductRepository

/**
 * AppContainer that is shareable between fragments for instantiating and dependency injecting
 * the ProductListFragment and its ViewModel
 */
class AppContainer {

    // The api client for fetching products from API endpoint
    private val remoteDataSource = Api.apiService

    // Client for local room database of products
    private lateinit var localDataSource: LocalDatabase

    lateinit var productRepository: ProductRepository

    // If there is already a ProductRepository instance, as Singleton representation
    private var instance: Boolean = false

    fun createLocalDataSource(context: Context) {
        localDataSource =
            Room.databaseBuilder(context, LocalDatabase::class.java, "productsDB").build()
    }

    fun createProductRepository(context: Context) {
        if (!instance && this::localDataSource.isInitialized) {
            productRepository = ProductRepository(remoteDataSource, localDataSource, context)
            instance = true
        }
    }
}