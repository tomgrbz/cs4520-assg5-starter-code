package com.cs4520.assignment5.data_layer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Entity class for Product with unique constraint on name and price, replacing on conflicts with
 * inserts
 */
@Entity(tableName = "products", indices = [Index(value = ["name", "price"], unique = true)])
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo(name = "expiry_date") val expiryDate: String?,
    val price: Double,
    val type: String
)

