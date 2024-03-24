package com.cs4520.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.cs4520.assignment5.application.ProductApplication
import com.cs4520.assignment5.databinding.MainActivityBinding



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (application as ProductApplication).appContainer
        application?.applicationContext?.let { appContainer.createLocalDataSource(it) }
        application?.applicationContext?.let { appContainer.createProductRepository(it) }
        setContent {

            AppNavigator(productRepo = appContainer.productRepository)

        }
//        binding = MainActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController

    }

}
