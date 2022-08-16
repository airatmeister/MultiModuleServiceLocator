package com.example.dashboard.presentation.state

import android.widget.TextView

interface Dashboard {

    fun apply(textView: TextView)

    class Base(private val text: String): Dashboard {

        override fun apply(textView: TextView) {
            textView.text = text
        }

    }
}