package com.cs4520.assignment5.model

import com.cs4520.assignment5.data_layer.ProductEntity
import java.lang.IllegalArgumentException

/**
 * Mapper class consisting of two static functions to map from Product to ProductEntity and
 * from ProductEntity to Product
 */
class ProductToDAOMapper {

    companion object {
        /**
         * Maps a Product type of either Food or Equipment to a Product Entity for db entry
         */
        fun productToProductEntity(product: Product): ProductEntity {
            return when (product.type) {
                "Food" -> {
                    ProductEntity(name = product.name!!, type = "Food", price = product.price!!, expiryDate = product.expiryDate)
                }
                "Equipment" -> {
                    ProductEntity(name = product.name!!, type = "Equipment", price = product.price!!, expiryDate = product.expiryDate)
                }
                else -> {
                    throw IllegalArgumentException("Invalid product given to mapper")
                }
            }

        }

        fun productEntityToProduct(productEntity: ProductEntity): Product? {
            return when (productEntity.type) {
                "Food" -> {
                    Product(productEntity.name, productEntity.expiryDate, productEntity.price, "Food")
                }
                "Equipment" -> {
                    Product(productEntity.name, productEntity.expiryDate, productEntity.price, "Equipment")
                }
                else -> {
                    throw IllegalArgumentException("Invalid product entity given to mapper")
                }
            }
        }
    }
}