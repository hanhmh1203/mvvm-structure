package com.example.gear_kotlin.usecase

import android.content.Context
import androidx.work.*
import com.example.gear_kotlin.workmanager.UploadWorker

class WorkerUsercase {
    operator fun invoke(context: Context){

        val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .setRequiresStorageNotLow(true)
            .setRequiresDeviceIdle(true)
            .build()


        var data = workDataOf(
            "times" to 2,
            "delay_time" to 2000L
        )
        val uploadWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setInputData(data)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(context).enqueue(uploadWorkRequest)
    }
}