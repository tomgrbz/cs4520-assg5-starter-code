package com.cs4520.assignment5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cs4520.assignment5.application.ProductApplication


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (application as ProductApplication).appContainer
        application?.applicationContext?.let { appContainer.createLocalDataSource(it) }
        application?.applicationContext?.let { appContainer.createProductRepository(it) }
        setContent {
            AppNavigator()
        }
    }

}
