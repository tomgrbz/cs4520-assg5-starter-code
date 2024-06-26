package com.cs4520.assignment5.model
//
//import kotlin.math.exp
//
//
//sealed class Product( name: String,  expiryDate: String?,  price: Double, type: String) {
//
//    data class Equipment(
//        val name: String,
//        val expiryDate: String?,
//        val price: Double
//    ) : Product(name, expiryDate, price)
//
//    data class Food(
//        val name: String,
//        val expiryDate: String?,
//        val price: Double
//    ) : Product(name, expiryDate, price)
//
//    companion object {
//        // Creates a Food or equipment based on given type, othewise null. Used for validating
//        // from API
//        fun create(name: Any?, type: Any?, expiryDate: Any?, price: Double?): Product? {
//            if (type == "Food") {
//                if (name != null && price != null && expiryDate != null) {
//                    return Food(name.toString(), expiryDate.toString(), price.toDouble())
//                }
//
//            } else {
//                if (name != null && price != null) {
//                    return Equipment(name.toString(), expiryDate.toString(), price.toDouble())
//                }
//
//            }
//            return null
//        }
//
//        // Compares two products based on type, followed by name and price
//        fun compareProduct(product1: ProductResponse, product2: ProductResponse): Boolean {
//            if (product1.type == "Food") {
//                if (product2.type != "Food") {
//                    return false
//                }
//                return product1.name == product2.name && product1.expiryDate == product2.expiryDate
//                        && product1.price == product2.price
//            } else if (product1.type == "Equipment") {
//                if (product2.type != "Equipment") {
//                    return false
//                }
//                return product1.name == product2.name && product1.expiryDate == null
//                        && product2.expiryDate == null
//                        && product1.price == product2.price
//            } else {
//                return false
//            }
//        }
//    }
//}
//
