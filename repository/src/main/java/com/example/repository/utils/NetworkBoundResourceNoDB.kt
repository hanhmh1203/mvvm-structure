package com.example.repository.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.coroutineContext

abstract class NetworkBoundResourceNoDB<ResultType, RequestType> {

    private val result = MutableLiveData<Resource<ResultType>>()
    private val supervisorJob = SupervisorJob()

    suspend fun build(): NetworkBoundResourceNoDB<ResultType, RequestType> {
        withContext(Dispatchers.Main) {
            result.value =
                Resource.loading(null)
        }
        CoroutineScope(coroutineContext).launch(supervisorJob) {
            val expectedResult = result.value?.data
            try {
                fetchFromNetwork(expectedResult)
            } catch (e: Exception) {
                Log.e("NetworkBoundResource", "An error happened: $e")
                setValue(Resource.error(e, expectedResult))
            }
        }
        return this
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    private suspend fun fetchFromNetwork(expectedResult: ResultType?) {
        Log.d(NetworkBoundResourceNoDB::class.java.name, "Fetch data from network")
        setValue(Resource.loading(expectedResult)) // Dispatch latest value quickly (UX purpose)
        val apiResponse = createCallAsync()
        Log.e(NetworkBoundResourceNoDB::class.java.name, "Data fetched from network")
        setValue(Resource.success(processResponse(apiResponse)))
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        Log.d(NetworkBoundResourceNoDB::class.java.name, "Resource: $newValue")
        if (result.value != newValue) result.postValue(newValue)
    }

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): ResultType

    @MainThread
    protected abstract suspend fun createCallAsync(): RequestType
}