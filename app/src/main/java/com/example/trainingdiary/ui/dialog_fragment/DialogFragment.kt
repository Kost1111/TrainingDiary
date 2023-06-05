package com.example.trainingdiary.ui.dialog_fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.trainingdiary.R
import com.example.trainingdiary.databinding.FragmentDialogBinding
import com.example.trainingdiary.utils.KEY_HEIGHT
import com.example.trainingdiary.utils.KEY_WEIGHT

class DialogFragment : DialogFragment() {

    private lateinit var sharedPreferencesHeight: SharedPreferences
    private lateinit var sharedPreferencesWeight: SharedPreferences
    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferencesHeight = context.getSharedPreferences(KEY_HEIGHT, Context.MODE_PRIVATE)
        sharedPreferencesWeight = context.getSharedPreferences(KEY_WEIGHT, Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

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

    @SuppressLint("CommitPrefEdits")
    private fun setupClickListeners() {
        binding.btnPositive.setOnClickListener {
            val weight = binding.editTextWeight.text.toString()
            val height = binding.editTextHeight.text.toString()
            sharedPreferencesHeight.edit().putString(KEY_HEIGHT, weight).apply()
            sharedPreferencesWeight.edit().putString(KEY_WEIGHT, height).apply()
            dismiss()
        }
        binding.btnNegative.setOnClickListener {
            dismiss()
        }

    }

    companion object {
        const val TAG = "SimpleDialog"
        fun newInstance(): com.example.trainingdiary.ui.dialog_fragment.DialogFragment =
            com.example.trainingdiary.ui.dialog_fragment.DialogFragment()
    }
}