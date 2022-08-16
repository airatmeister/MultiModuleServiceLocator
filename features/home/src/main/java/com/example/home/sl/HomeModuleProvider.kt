package com.example.home.sl

import androidx.lifecycle.ViewModel
import com.example.home.presentation.screens.HomeContainerViewModel
import com.example.home.presentation.screens.main.HomeMainViewModel
import com.test.core.sl.DependencyContainer

class HomeModuleProvider(
    private val dependencyContainer: DependencyContainer
    ) {

    fun <T : ViewModel> provide(clazz: Class<T>) = when(clazz){
        HomeContainerViewModel::class.java -> HomeModule()
        HomeMainViewModel::class.java -> HomeMainModule()
        else -> dependencyContainer.module(clazz)
    }

    fun getArrayOfViewModels(): Array<Class<*>> =
        arrayOf(
            HomeContainerViewModel::class.java,
            HomeMainViewModel::class.java
        )
}