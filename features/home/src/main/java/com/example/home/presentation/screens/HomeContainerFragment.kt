package com.example.home.presentation.screens

import android.os.Bundle
import android.view.View
import com.example.home.NavAction
import com.example.home.R
import com.example.home.databinding.FragmentHomeContainerBinding
import com.example.home.presentation.screens.main.HomeMainFragment
import com.test.core.plugins.viewbinding.viewBinding
import com.test.core.presentation.UiAction
import com.test.core.presentation.base.BaseFragment

class HomeContainerFragment : BaseFragment<HomeContainerViewModel>(R.layout.fragment_home_container) {

    private val binding by viewBinding(FragmentHomeContainerBinding::bind)
    override fun viewModelClass() = HomeContainerViewModel::class.java

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding){
        childFragmentManager.beginTransaction().add(R.id.homeFragmentContainerView, HomeMainFragment.newInstance()).commit()
        val btnOnClick: (View) -> Unit = {
            navigator.navigateTo(UiAction(NavAction.NAVIGATIONS_FEATURE))
        }
        btnDashboardFeature.setOnClickListener(btnOnClick)
    }

    override fun onBindViewModel() = Unit
}