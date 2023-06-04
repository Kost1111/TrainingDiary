package com.example.trainingdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.trainingdiary.databinding.FragmentResultsBinding


class ResultsFragment : BaseFragment<FragmentResultsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentResultsBinding =
        FragmentResultsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.setRulerParams.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_navigation_results_to_setBodyParams)
        }

    }
}