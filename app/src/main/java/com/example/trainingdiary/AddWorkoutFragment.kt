package com.example.trainingdiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingdiary.databinding.FragmentAddWorkoutBinding
import com.example.trainingdiary.databinding.FragmentHomeBinding


class AddWorkoutFragment : BaseFragment<FragmentAddWorkoutBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentAddWorkoutBinding =
        FragmentAddWorkoutBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}