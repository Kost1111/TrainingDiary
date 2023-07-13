package com.example.trainingdiary.ui.fragments.dialog

import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.trainingdiary.R

abstract class AbstractDialogFragment : DialogFragment() {

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun getTheme(): Int {
        return R.style.dialog
    }

}