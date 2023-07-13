package com.example.trainingdiary.ui.fragments.dialog

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
import com.example.trainingdiary.ui.utils.KEY_HEIGHT
import com.example.trainingdiary.ui.utils.KEY_WEIGHT

class AddParamsDialogFragment : AbstractDialogFragment() {

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

    @SuppressLint("CommitPrefEdits")
    private fun setupClickListeners() {
        binding.btnPositive.setOnClickListener {
            val weight = binding.editTextWeight.text.toString().toFloat()
            val height = binding.editTextHeight.text.toString().toFloat()
            sharedPreferencesHeight.edit().putFloat(KEY_HEIGHT, weight).apply()
            sharedPreferencesWeight.edit().putFloat(KEY_WEIGHT, height).apply()
            val bundle = Bundle()
            bundle.putFloat(KEY_HEIGHT, weight)
            bundle.putFloat(KEY_WEIGHT, height)
            arguments = bundle
            dismiss()
        }
        binding.btnNegative.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG = "SimpleDialog"
        fun newInstance(): com.example.trainingdiary.ui.fragments.dialog.AddParamsDialogFragment =
            com.example.trainingdiary.ui.fragments.dialog.AddParamsDialogFragment()
    }
}