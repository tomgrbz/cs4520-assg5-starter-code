package com.cs4520.assignment5.data_layer

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

/**
 * Custom coroutine worker that fetches and updates product list in DB
 */
class RefreshDataWorker(
    private val appContext: Context,
    workerParams: WorkerParameters,

    ) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            // Init services for remote and local sources of product list data
            val remoteSource = Api.apiService
            val localDB = LocalDatabase.instance(appContext)
            val repo = ProductRepository(remoteSource, localDB, appContext)
            // Fetch products from the API
            repo.getProducts((1..10).random())
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

}
