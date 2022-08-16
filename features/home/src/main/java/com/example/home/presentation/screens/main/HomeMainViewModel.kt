package com.example.home.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home.presentation.screens.main.state.Home

class HomeMainViewModel : ViewModel() {

    private val _text = MutableLiveData<Home>().apply {
        value = Home.Base("This is home Fragment")
    }
    val text: LiveData<Home> = _text
}