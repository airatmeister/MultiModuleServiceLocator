package com.example.notifications.sl

import android.content.Context
import android.preference.PreferenceManager
import com.example.notifications.data.UserRepository
import com.example.notifications.data.cache.CacheDataSource
import com.example.notifications.presentation.NotificationsViewModel
import com.example.notifications.presentation.mapper.DataToUiMapper
import com.test.core.sl.base.BaseModule

class NotificationsModule(private val context: Context): BaseModule<NotificationsViewModel> {

    override fun viewModel(): NotificationsViewModel {
        return NotificationsViewModel(context, provideUserRepository(), provideDataToUiMapper())
    }

    private fun provideUserRepository(): UserRepository {
        return UserRepository.Base(provideCacheDataSource())
    }

    private fun provideCacheDataSource(): CacheDataSource {
        return CacheDataSource.Base(PreferenceManager.getDefaultSharedPreferences(context))
    }

    private fun provideDataToUiMapper() = DataToUiMapper.Base()
}