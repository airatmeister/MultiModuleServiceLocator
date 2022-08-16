package com.example.notifications.sl

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.notifications.presentation.NotificationsViewModel
import com.test.core.sl.DependencyContainer

class NotificationsModuleProvider (
    private val context: Context,
    private val dependencyContainer: DependencyContainer
) {

    fun <T : ViewModel> provide(clazz: Class<T>) = when(clazz){
        NotificationsViewModel::class.java -> NotificationsModule(context)
        else -> dependencyContainer.module(clazz)
    }

    fun getArrayOfViewModels(): Array<Class<*>> = arrayOf(NotificationsViewModel::class.java)
}