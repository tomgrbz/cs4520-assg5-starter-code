package com.cs4520.assignment5.application

import android.app.Application
import android.content.Context
import androidx.work.Configuration
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import com.cs4520.assignment5.data_layer.RefreshDataWorker
import com.cs4520.assignment5.data_layer.WorkManagerSingleton
import java.util.concurrent.TimeUnit

/**
 * Custom application instance that holds onto a app container object for dependency injection
 * and instantiation of local and remote sources for the ProductRepository
 */
class ProductApplication: Application() {
    val appContainer: AppContainer = AppContainer()

    override fun onCreate() {
        super.onCreate()
        scheduleProductRefresh(applicationContext)
    }


    fun scheduleProductRefresh(context: Context) {
        val workManger = WorkManagerSingleton.getInstance(context = context);
        val workRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(15, TimeUnit.MINUTES)
            .setConstraints(Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())
            .build()

        workManger.enqueueUniquePeriodicWork(
            "refreshProducts",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }
}