package com.example.trainingdiary.ui.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import com.example.trainingdiary.R

class TrainingDiaryToolbar@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): Toolbar(context, attrs, defStyleAttr) {

    init {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?){
        inflate(context, R.layout.view_training_diaty_toolbar,this)
        setContentInsetsAbsolute(0, 0)

    }




}