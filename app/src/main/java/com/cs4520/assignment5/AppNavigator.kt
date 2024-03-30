package com.cs4520.assignment5

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cs4520.assignment5.data_layer.ProductRepository
import com.cs4520.assignment5.ui.LoginScreen
import com.cs4520.assignment5.ui.ProductListScreen

@Composable
fun AppNavigator(productRepo: ProductRepository) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productList") {
        composable("login") { LoginScreen(onLoginSuccess = { navController.navigate("productList") }) }
         composable("productList") { ProductListScreen(productRepo) }
    }
}


