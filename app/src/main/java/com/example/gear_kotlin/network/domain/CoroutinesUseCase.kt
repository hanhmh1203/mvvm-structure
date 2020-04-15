package io.philippeboisney.home.domain

import android.provider.Settings
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.commons.AppDispatchers
import com.example.commons.extension.williamLog
import com.example.gear_kotlin.ui.AppFirstFragment
import com.example.model.UserGit
import com.example.repository.UserGitRepository
import com.example.repository.utils.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis

/**
 * Use case that gets a [Resource][List][User] from [UserRepository]
 * and makes some specific logic actions on it.
 *
 * In this Use Case, I'm just doing nothing... ¯\_(ツ)_/¯
 */
class CoroutinesUseCase {
    operator fun invoke() {
//        runWithAsync()
//        runWithOutAsync()
//        runWithGlobalAsync()
        coroutineScope2()
    }

    /**
     * async return a Deferred object
     */
    private fun runWithAsync() {
        williamLog("runWithAsync before")
        GlobalScope.launch {
            val one = async {
                withContext(Dispatchers.IO) {
                    someBusyFunction("IO")
                }
            }
            val two = async {
                withContext(Dispatchers.Main) {
                    someBusyFunction("MAIN")
                }
                "wir"
            }
            val time1 = measureTimeMillis { one.await() }
            val time2 = measureTimeMillis { two.await() }
            williamLog("total time of runWithAsync need to run: ${time1 + time2}")
        }
        williamLog("runWithAsync after")
        //
//        Single stream


    }

    private fun runWithGlobalAsync() {
        williamLog("runWithGlobalAsync before")
        val global = GlobalScope.async {
            someBusyFunction("IO")
            someBusyFunction("MAIN")
        }
        val time = measureTimeMillis {
            runBlocking {
                williamLog("runWithGlobalAsync run in block before await")
                global.await()
                williamLog("runWithGlobalAsync run in block after await")
            }
        }

        williamLog("runWithGlobalAsync after")
        williamLog("total time of runWithGlobalAsync need to run: ${time}")
    }

    /**
     * block code with Coroutines scope
     */
    private fun runWithBlocking() {
        williamLog("runWithBlocking before")
        runBlocking {
            williamLog("runblocking before delay ")
            delay(5000L)
            williamLog("runblocking after delay ")

        }
        williamLog("runWithBlocking after")
    }

    private fun runWithOutAsync() {
        williamLog("runWithOutAsync before")

        GlobalScope.launch {
            val time = measureTimeMillis {
                withContext(Dispatchers.IO) {
                    someBusyFunction("IO 1")
                }
                withContext(Dispatchers.Main) {
                    someBusyFunction("MAIN")
                }
            }
            williamLog("total time of runWithOutAsync need to run: $time")
        }
        williamLog("runWithOutAsync after")
    }

    private suspend fun someBusyFunction(thread: String): Unit {
        williamLog("$thread Printed before 5 second")
        delay(5000L)
        williamLog("$thread Printed after 5 second")
    }

    private fun coroutineScope() = runBlocking { // this: CoroutineScope
        launch {
            delay(1000L)
            williamLog("Task from runBlocking")
        }

        coroutineScope { // Creates a new coroutine scope
            launch {
                delay(500L)
                williamLog("Task from nested launch")
            }

            delay(200L)
            williamLog("Task from coroutine scope") // This line will be printed before nested launch
        }

        williamLog("Coroutine scope is over") // This line is not printed until nested launch completes
    }

    private fun coroutineScope2() = runBlocking { // this: CoroutineScope
        launch {
            delay(1000L)
            williamLog("Task from runBlocking")
        }
        runBlocking {
            launch {
                delay(500L)
                williamLog("Task from nested launch")
            }
            delay(200L)
            williamLog("Task from coroutine scope")
        }

        williamLog("Coroutine scope is over") // This line is not printed until nested launch completes
    }
}