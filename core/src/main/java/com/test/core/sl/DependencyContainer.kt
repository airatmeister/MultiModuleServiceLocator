package com.test.core.sl

import androidx.lifecycle.ViewModel
import com.test.core.sl.base.BaseModule

interface DependencyContainer {
    fun <T : ViewModel> module(clazz: Class<T>): BaseModule<*>

    class Error : DependencyContainer {

        override fun <T : ViewModel> module(clazz: Class<T>): BaseModule<*> {
            throw IllegalStateException("no module found for $clazz")
        }
    }
}