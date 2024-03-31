package com.cs4520.assignment5.data_layer

import android.content.Context
import android.util.Log
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
            val result = repo.getProducts((1..10).random())
            Log.d("RefreshWorker", "Received resp: $result")
            //Log.e("RefreshWorkerE", "Received resp: $result")
            Result.success()
        } catch (e: Exception) {
            Log.d("RefreshWorker", "Errored out: $e")
            Result.retry()
        }
    }

}
