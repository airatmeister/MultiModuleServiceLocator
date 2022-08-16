package com.example.notifications.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notifications.data.UserRepository
import com.example.notifications.presentation.mapper.DataToUiMapper
import com.example.notifications.presentation.state.NotificationsState

class NotificationsViewModel(
    private val context: Context, /** Application Context **/
    private val userRepository: UserRepository,
    private val mapper: DataToUiMapper
    ) : ViewModel() {

    private val _notificationsState = MutableLiveData<NotificationsState>()
    val notificationsState: LiveData<NotificationsState> = _notificationsState

    fun saveUser(name: String, secondName: String){
        userRepository.saveName(name)
        userRepository.saveSecondName(secondName)
        _notificationsState.value = NotificationsState.ShowToast(context)
    }

    fun getUserInfo(){
        _notificationsState.value = NotificationsState.ShowUserInfo(mapper.map(userRepository.fetchUser()))
    }
}