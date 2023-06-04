package com.example.trainingdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingdiary.databinding.FragmentSetBodyParamsBinding


class SetBodyParams : BaseFragment<FragmentSetBodyParamsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentSetBodyParamsBinding =
        FragmentSetBodyParamsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}