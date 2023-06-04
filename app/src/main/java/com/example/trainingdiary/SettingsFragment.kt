package com.example.trainingdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.trainingdiary.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentSettingsBinding =
        FragmentSettingsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.switchTheme.setOnCheckedChangeListener { _, _ ->
            colorChange(binding.switchTheme.isChecked)
        }
    }

    fun colorChange(isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}