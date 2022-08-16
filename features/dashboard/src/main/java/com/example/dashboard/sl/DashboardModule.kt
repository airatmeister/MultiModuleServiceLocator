package com.example.dashboard.sl

import com.example.dashboard.presentation.DashboardViewModel
import com.test.core.sl.base.BaseModule

class DashboardModule : BaseModule<DashboardViewModel> {
    override fun viewModel(): DashboardViewModel {
        return DashboardViewModel()
    }
}