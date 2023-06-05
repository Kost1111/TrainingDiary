package com.example.trainingdiary.ui.exercises_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingdiary.databinding.FragmentExercisesBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment


class ExercisesFragment : BaseFragment<FragmentExercisesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentExercisesBinding =
        FragmentExercisesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}