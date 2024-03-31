package com.cs4520.assignment5.data_layer

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/**
 * Singleton class holding on to instance of a work manager
 */
object WorkManagerSingleton {
    private var workManager: WorkManager? = null

    fun getInstance(context: Context): WorkManager {
        return workManager ?: synchronized(this) {
            WorkManager.getInstance(context).also {
                workManager = it
            }
        }
    }

    fun scheduleProductRefresh(context: Context) {
        val workManger = getInstance(context = context);
        val workRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.HOURS)
            .setInitialDelay(1, TimeUnit.HOURS)
            .setConstraints(
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            )
            .build()

        workManger.enqueueUniquePeriodicWork(
            "refreshProducts",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
    }
}
