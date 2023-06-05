package com.example.trainingdiary.ui.add_workout_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.databinding.FragmentAddWorkoutBinding


class AddWorkoutFragment : BaseFragment<FragmentAddWorkoutBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentAddWorkoutBinding =
        FragmentAddWorkoutBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}