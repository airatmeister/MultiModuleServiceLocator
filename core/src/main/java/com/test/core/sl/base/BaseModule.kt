package com.test.core.sl.base

import androidx.lifecycle.ViewModel

interface BaseModule<T : ViewModel> {
    fun viewModel(): T
}