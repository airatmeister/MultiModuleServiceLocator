package com.example.home.presentation.screens.main.state

import android.widget.TextView

interface Home {

    fun apply(textView: TextView)

    class Base(private val text: String): Home {

        override fun apply(textView: TextView) {
            textView.text = text
        }

    }
}