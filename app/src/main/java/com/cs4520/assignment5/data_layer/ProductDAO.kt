package com.cs4520.assignment5.data_layer

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * DAO Object
 */
@Dao
interface ProductDAO {
    @Query("SELECT * FROM products")
    suspend fun fetchAllProducts(): List<ProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProducts(products: List<ProductEntity>)


}