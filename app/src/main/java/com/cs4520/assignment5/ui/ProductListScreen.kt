package com.cs4520.assignment5.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cs4520.assignment5.data_layer.ProductRepository
import com.cs4520.assignment5.view_model.ProductListViewModel
import androidx.compose.foundation.lazy.items
import com.cs4520.assignment5.application.ProductApplication

@Composable
fun ProductListScreen(productRepo: ProductRepository) {
    val viewModel: ProductListViewModel = viewModel(factory = ProductListViewModel.Factory)
    val products by viewModel.products.collectAsState()


    LazyColumn {
        items(products) { product ->
            ProductRow(product)
        }
    }
}