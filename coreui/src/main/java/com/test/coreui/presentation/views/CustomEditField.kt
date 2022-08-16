package com.test.coreui.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.test.coreui.databinding.ViewCustomEditFieldBinding

class CustomEditField: LinearLayout {

    private val binding = ViewCustomEditFieldBinding.inflate(LayoutInflater.from(context), this)

    constructor(context: Context) : super(context) {
        initLayout(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initLayout(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initLayout(context, attrs, defStyle)
    }

    private fun initLayout(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) {
        this.orientation = VERTICAL
    }

    fun getName() = binding.editTextName.text.toString()
    fun getSecondName() = binding.editTextSecondName.text.toString()
}