package com.test.core.plugins

interface BasePlugin {
    fun onLifecycleEvent(event: LifecycleEvent)
}