package com.example.trainingdiary.ui.fragments.results

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.trainingdiary.R
import com.example.trainingdiary.data.BodyParcelable
import com.example.trainingdiary.databinding.FragmentResultsBinding
import com.example.trainingdiary.ui.fragments.base.BaseFragment
import com.example.trainingdiary.ui.fragments.dialog.AddParamsDialogFragment
import com.example.trainingdiary.ui.utils.KEY_BODY
import com.example.trainingdiary.ui.utils.KEY_HEIGHT
import com.example.trainingdiary.ui.utils.KEY_WEIGHT
import com.google.gson.Gson


class ResultsFragment : BaseFragment<FragmentResultsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentResultsBinding =
        FragmentResultsBinding::inflate

    private lateinit var sharedPreferencesHeight: SharedPreferences
    private lateinit var sharedPreferencesWeight: SharedPreferences
    private lateinit var sharedPreferencesBodyParcelable: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferencesHeight = context.getSharedPreferences(KEY_HEIGHT, Context.MODE_PRIVATE)
        sharedPreferencesWeight = context.getSharedPreferences(KEY_WEIGHT, Context.MODE_PRIVATE)
        sharedPreferencesBodyParcelable =
            context.getSharedPreferences(KEY_BODY, Context.MODE_PRIVATE)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val json = sharedPreferencesBodyParcelable.getString(KEY_BODY, null)
        val height = sharedPreferencesHeight.getFloat(KEY_HEIGHT, 0f)
        val weight = sharedPreferencesWeight.getFloat(KEY_WEIGHT, 0f)
        binding.apply {

            tvHeight.text = height.toString()
            tvWeight.text = weight.toString()
            tvFat.text = checkFat(weight, height)
            setRulerParams.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_navigation_results_to_setBodyParams)
            }
            setWeightParams.setOnClickListener {
                AddParamsDialogFragment.newInstance().show(fragmentManager!!, AddParamsDialogFragment.TAG)
            }
        }
        val bodySavedParams = Gson().fromJson(json, BodyParcelable::class.java)
        setBodyParams(bodySetParam = bodySavedParams)
    }

    override fun onStart() {
        super.onStart()
        binding.tvHeight.text = sharedPreferencesHeight.getFloat(KEY_HEIGHT, 0f).toString()
        binding.tvWeight.text = sharedPreferencesWeight.getFloat(KEY_WEIGHT, 0f).toString()
    }

    private fun checkFat(weight: Float, height: Float): String {
        return if (weight == 0f || height == 0f) {
            "---"
        } else {
            val result = weight / (height * height) * 10000
            "$result"
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setBodyParams(bodySetParam: BodyParcelable?) {
        if (bodySetParam != null) {
            binding.apply {
                neck.text = bodySetParam.neck + " cм"
                back.text = bodySetParam.back + " cм"
                belly.text = bodySetParam.belly + " cм"
                breasts.text = bodySetParam.breasts + " cм"
                waist.text = bodySetParam.waist + " cм"
                forearmRight.text = bodySetParam.forearmRight + " cм"
                forearmLeft.text = bodySetParam.forearmLeft + " cм"
            }
        }
    }
}