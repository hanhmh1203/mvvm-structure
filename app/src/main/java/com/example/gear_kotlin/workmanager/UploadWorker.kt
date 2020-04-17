package com.example.gear_kotlin.workmanager

import android.content.Context
import android.content.Intent
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.commons.extension.williamLog
import com.example.gear_kotlin.ui.MainActivity
import kotlinx.coroutines.*

class UploadWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        return try {
            val times = inputData.getInt("times", 1)
            val time = inputData.getLong("delay_time", 1000L)
            williamLog("times $times and delay_time: $time")
            GlobalScope.launch {
                (0..times).forEach {
                    delay(time)
                    williamLog("uploadWorker $it")

                    withContext(Dispatchers.Main) {
                        applicationContext.startActivity(
                            Intent(
                                applicationContext,
                                MainActivity::class.java
                            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                    }
                }
            }

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}