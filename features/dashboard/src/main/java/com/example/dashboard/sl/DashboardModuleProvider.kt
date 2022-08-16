package com.example.dashboard.sl

import androidx.lifecycle.ViewModel
import com.example.dashboard.presentation.DashboardViewModel
import com.test.core.sl.DependencyContainer

class DashboardModuleProvider (
    private val dependencyContainer: DependencyContainer
) {

    fun <T : ViewModel> provide(clazz: Class<T>) = when(clazz){
        DashboardViewModel::class.java -> DashboardModule()
        else -> dependencyContainer.module(clazz)
    }

    fun getArrayOfViewModels(): Array<Class<*>> = arrayOf(DashboardViewModel::class.java)
}