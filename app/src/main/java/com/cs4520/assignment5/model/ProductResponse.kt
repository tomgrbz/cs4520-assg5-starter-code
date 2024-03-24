package com.cs4520.assignment5.model

class Product(
    val name: String?,
    val expiryDate: String?,
    val price: Double?,
    val type: String?
) {
    companion object {
        // Compares two products based on type, followed by name and price
        fun compareProduct(product1: Product, product2: Product): Boolean {
            if (product1.type == "Food") {
                if (product2.type != "Food") {
                    return false
                }
                return product1.name == product2.name && product1.expiryDate == product2.expiryDate
                        && product1.price == product2.price
            } else if (product1.type == "Equipment") {
                if (product2.type != "Equipment") {
                    return false
                }
                return product1.name == product2.name && product1.expiryDate == null
                        && product2.expiryDate == null
                        && product1.price == product2.price
            } else {
                return false
            }
        }
    }
}