package com.example.dashboard.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dashboard.presentation.state.Dashboard

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<Dashboard>().apply {
        value = Dashboard.Base("This is dashboard Fragment")
    }
    val text: LiveData<Dashboard> = _text
}