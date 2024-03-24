package com.cs4520.assignment5.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cs4520.assignment5.R
import com.cs4520.assignment5.model.Product


@Composable
fun ProductRow(product: Product) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = colorResource(id = if (product.type == "Food") R.color.light_yellow else R.color.light_red),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = if (product.type == "Food") R.drawable.food else R.drawable.equipment),
                contentDescription = null,
                modifier = Modifier.requiredSize(100.dp, 100.dp),
                contentScale = ContentScale.Crop

            )
            Column(modifier = Modifier.padding(8.dp)) {
                product.name?.let { Text(text = it, fontWeight = FontWeight.Bold) }
                if (product.type == "Food") {
                    Text(text = "Expiry: ${product.expiryDate}")
                }
                Text(text = "Price: ${product.price}")
            }
        }
    }
}
