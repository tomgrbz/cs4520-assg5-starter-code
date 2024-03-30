package com.cs4520.assignment5.data_layer

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.cs4520.assignment5.application.AppContainer
import com.cs4520.assignment5.application.ProductApplication

class RefreshDataWorker(
    private val appContext: Context,
    workerParams: WorkerParameters,

) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            // Fetch products from the API
            val remoteSource = Api.apiService
            val localDB = LocalDatabase.instance(appContext)
            val repo = ProductRepository(remoteSource, localDB, appContext)
            repo.getProducts((1..10).random())
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

}
