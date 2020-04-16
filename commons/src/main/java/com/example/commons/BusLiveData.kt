package com.example.commons

import androidx.lifecycle.MutableLiveData
import com.example.commons.extension.williamLog
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

class BusLiveData {
    @ExperimentalCoroutinesApi
    operator fun invoke() {

//        ConflatedBroadcastChannel
//        br.onSend
        williamLog("BusLiveData hanhmai")
//        br.openSubscription()
//        GlobalScope.launch {
//            br.consumeEach {
//                williamLog("hanhmai $it")
//            }
//        }
//        br.onSend
//        br.openSubscription()
        if (!br.isClosedForSend)
            br.offer(15)
    }

    //    var br: ConflatedBroadcastChannel<Int> = ConflatedBroadcastChannel()
    companion object {
        var br: ConflatedBroadcastChannel<Int> = ConflatedBroadcastChannel()
    }
}

data class CustomEvent(val eventProp: String)