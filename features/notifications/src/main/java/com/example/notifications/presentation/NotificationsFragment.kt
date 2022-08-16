package com.example.notifications.presentation

import android.os.Bundle
import com.example.notifications.R
import com.example.notifications.databinding.FragmentNotificationsBinding
import com.test.core.plugins.viewbinding.viewBinding
import com.test.core.presentation.base.BaseFragment

class NotificationsFragment : BaseFragment<NotificationsViewModel>(R.layout.fragment_notifications) {

    private val binding by viewBinding(FragmentNotificationsBinding::bind)
    override fun viewModelClass() = NotificationsViewModel::class.java

    override fun callOperations() = Unit
    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        btnSave.setOnClickListener {
            viewModel.saveUser(editField.getName(), editField.getSecondName())
        }
        btnRestore.setOnClickListener {
            viewModel.getUserInfo()
        }
    }

    override fun onBindViewModel() = with(viewModel) {
        notificationsState.observe{
            it.apply(binding.textNotifications)
        }
    }
}