package com.example.trainingdiary.ui.results_fragment

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
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.ui.dialog_fragment.DialogFragment
import com.example.trainingdiary.utils.KEY_BODY
import com.example.trainingdiary.utils.KEY_HEIGHT
import com.example.trainingdiary.utils.KEY_WEIGHT
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
        val height = sharedPreferencesHeight.getString(KEY_HEIGHT, "---")
        val weight = sharedPreferencesWeight.getString(KEY_WEIGHT, "---")
        binding.apply {
            tvHeight.text = height
            tvWeight.text = weight
            tvFat.text = checkFat(weight!!.toDouble(), height!!.toDouble())
            setRulerParams.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_navigation_results_to_setBodyParams)
            }
            setWeightParams.setOnClickListener {
                DialogFragment.newInstance().show(fragmentManager!!, DialogFragment.TAG)
            }
        }
        val bodySavedParams = Gson().fromJson(json, BodyParcelable::class.java)
        setBodyParams(bodySetParam = bodySavedParams)
    }

    override fun onStart() {
        super.onStart()
        binding.tvHeight.text = sharedPreferencesHeight.getString(KEY_HEIGHT, "---")
        binding.tvWeight.text = sharedPreferencesWeight.getString(KEY_WEIGHT, "---")
    }

    private fun checkFat(weight: Double, height: Double): String {
        val result = weight / (height * height) * 10000
        return "$result"
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