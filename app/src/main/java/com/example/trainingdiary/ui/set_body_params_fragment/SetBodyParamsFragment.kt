package com.example.trainingdiary.ui.set_body_params_fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.trainingdiary.R
import com.example.trainingdiary.data.BodyParcelable
import com.example.trainingdiary.databinding.FragmentSetBodyParamsBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.utils.KEY_BODY
import com.google.gson.Gson


class SetBodyParamsFragment : BaseFragment<FragmentSetBodyParamsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentSetBodyParamsBinding =
        FragmentSetBodyParamsBinding::inflate

    private lateinit var sharedPreferencesBodyParcelable: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferencesBodyParcelable =
            context.getSharedPreferences(KEY_BODY, Context.MODE_PRIVATE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddBodyParams.setOnClickListener {
            val neck = binding.inputNeck.text.toString()
            val back = binding.inputBack.text.toString()
            val belly = binding.inputBelly.text.toString()
            val breasts = binding.inputBreast.text.toString()
            val waist = binding.inputWaist.text.toString()
            val forearmRight = binding.inputForearmRight.text.toString()
            val forearmLeft = binding.inputForearmLeft.text.toString()
            val body = BodyParcelable(
                neck, back, belly, breasts, waist, forearmRight, forearmLeft
            )
            val json = Gson().toJson(body)
            sharedPreferencesBodyParcelable.edit().putString(KEY_BODY, json).apply()
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_setBodyParams_to_navigation_results)
        }
    }
}