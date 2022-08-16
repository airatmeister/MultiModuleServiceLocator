package com.example.home.presentation.screens.main

import android.os.Bundle
import com.example.home.R
import com.example.home.databinding.FragmentHomeBinding
import com.test.core.plugins.viewbinding.viewBinding
import com.test.core.presentation.base.BaseFragment

class HomeMainFragment : BaseFragment<HomeMainViewModel>(R.layout.fragment_home) {

    companion object { fun newInstance() = HomeMainFragment() }

    private val binding by viewBinding(FragmentHomeBinding::bind)
    override fun viewModelClass() = HomeMainViewModel::class.java

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?)  = with(binding){

    }

    override fun onBindViewModel() = with(viewModel){
        text.observe {
            it.apply(binding.textHome)
        }
    }
}