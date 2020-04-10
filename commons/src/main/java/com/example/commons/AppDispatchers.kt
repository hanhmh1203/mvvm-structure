package com.example.commons

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AppDispatchers @Inject constructor(val main: CoroutineDispatcher,
                     val io: CoroutineDispatcher, val default: CoroutineDispatcher)