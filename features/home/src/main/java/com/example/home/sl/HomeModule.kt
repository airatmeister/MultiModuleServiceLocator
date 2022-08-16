package com.example.home.sl

import com.example.home.presentation.screens.HomeContainerViewModel
import com.test.core.sl.base.BaseModule

class HomeModule: BaseModule<HomeContainerViewModel> {

    override fun viewModel(): HomeContainerViewModel {
        return HomeContainerViewModel()
    }
}