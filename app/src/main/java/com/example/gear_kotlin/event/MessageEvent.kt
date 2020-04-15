package com.example.gear_kotlin.event

import android.os.Message

class MessageEvent(requestCode: Int, message: Message) {

    companion object {
        val REQUEST_MOOD_RATING_DONE = 0
    }
}