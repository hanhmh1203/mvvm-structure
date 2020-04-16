package com.example.gear_kotlin.event

import android.os.Message

class MessageEvent(var requestCode: Int, var message: Message) {

    companion object {
        val REQUEST_MOOD_RATING_DONE = 0
    }
}