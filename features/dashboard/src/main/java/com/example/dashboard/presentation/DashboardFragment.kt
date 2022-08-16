package com.example.dashboard.presentation

import android.os.Bundle
import android.view.View
import com.example.dashboard.NavAction
import com.example.dashboard.R
import com.example.dashboard.databinding.FragmentDashboardBinding
import com.test.core.plugins.viewbinding.viewBinding
import com.test.core.presentation.UiAction
import com.test.core.presentation.base.BaseFragment

class DashboardFragment : BaseFragment<DashboardViewModel>(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)
    override fun viewModelClass() = DashboardViewModel::class.java

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding){
        val btnOnClick: (View) -> Unit = {
            navigator.navigateTo(UiAction(NavAction.NAVIGATIONS_FEATURE))
        }
        btnNotificationsFeature.setOnClickListener(btnOnClick)
    }

    override fun onBindViewModel() = with(viewModel) {
        text.observe {
            it.apply(binding.textDashboard)
        }
    }
}