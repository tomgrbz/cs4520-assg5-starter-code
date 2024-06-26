package com.cs4520.assignment5.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cs4520.assignment5.data_layer.ProductRepository
import com.cs4520.assignment5.view_model.ProductListViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs4520.assignment5.application.ProductApplication

/**
 * Composable function representing the view of list of products
 * fetched from API. Uses lazy column composable to process product row composables.
 */
@Composable
fun ProductListScreen() {
    val viewModel: ProductListViewModel = viewModel(factory = ProductListViewModel.Factory)
    val products by viewModel.products.collectAsState()
    val loading by viewModel.isLoading.collectAsState()
    if (loading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        if (products.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Products Available", fontSize = 18.sp)
            }
        } else {
            LazyColumn {
                items(products) { product ->
                    ProductRow(product)
                }
            }
        }
    }
}