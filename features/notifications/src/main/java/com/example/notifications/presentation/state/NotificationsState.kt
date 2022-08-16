package com.example.notifications.presentation.state

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.example.notifications.presentation.model.User

interface NotificationsState {
    fun apply(textView: TextView)

    class ShowToast(private val context: Context): NotificationsState{

        override fun apply(textView: TextView) =
            Toast.makeText(context, "User added", Toast.LENGTH_LONG).show()
    }

    class ShowUserInfo(private val user: User): NotificationsState {

        override fun apply(textView: TextView) {
            user.let { (name, secondName) ->
                val text = "$name $secondName"
                textView.text = text
            }
        }
    }
}