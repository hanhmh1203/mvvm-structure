package com.example.gear_kotlin.event

import org.greenrobot.eventbus.EventBus

class EventManager {

    companion object{
        @Volatile
        private var  sSharedInstance: EventManager?= null
        private var sEventBus: EventBus? = null
        fun getSharedInstance(): EventManager {
            if (sSharedInstance == null) {
                synchronized(EventManager::class.java) {
                    if (sSharedInstance == null) {
                        sSharedInstance = EventManager()
                    }
                }
            }
            return sSharedInstance!!
        }
    }

    init {
        sEventBus = EventBus.builder()
            .sendSubscriberExceptionEvent(false)
            .sendNoSubscriberEvent(false)
            .logNoSubscriberMessages(false)
            .logSubscriberExceptions(false)
            .build()
    }

    fun post(event: Any?) {
        sEventBus?.post(event)
    }

    fun postSticky(event: Any?) {
        sEventBus?.postSticky(event)
    }

    fun register(subscriber: Any?) {
        if (!sEventBus?.isRegistered(subscriber)!!) {
            sEventBus?.register(subscriber)
        }
    }

    fun unregister(subscriber: Any?) {
        if (sEventBus?.isRegistered(subscriber)!!) {
            sEventBus?.unregister(subscriber)
        }
    }

}