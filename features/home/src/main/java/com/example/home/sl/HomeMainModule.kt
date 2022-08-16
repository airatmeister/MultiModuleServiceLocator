package com.example.home.sl

import com.example.home.presentation.screens.main.HomeMainViewModel
import com.test.core.sl.base.BaseModule

class HomeMainModule: BaseModule<HomeMainViewModel> {
    override fun viewModel(): HomeMainViewModel {
        return HomeMainViewModel()
    }
}