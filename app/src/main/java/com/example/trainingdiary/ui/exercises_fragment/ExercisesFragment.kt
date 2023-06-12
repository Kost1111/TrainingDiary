package com.example.trainingdiary.ui.exercises_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdiary.R
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.FragmentExercisesBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.ui.exercises_adapter.AdapterExercises
import com.example.trainingdiary.utils.usersExercises


class ExercisesFragment : BaseFragment<FragmentExercisesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentExercisesBinding =
        FragmentExercisesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPlaceholder()
        val adapter = AdapterExercises()
        adapter.submitList(usersExercises.toList())
        binding.recyclerViewUsersExercises.adapter = adapter
        binding.recyclerViewUsersExercises.layoutManager = LinearLayoutManager(requireContext())
        binding.btnMoreExercises.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_navigation_exercises_to_addNewExercisesFragment)
        }
        binding.btnAddExercises.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_navigation_exercises_to_addNewExercisesFragment)
        }
    }

    private fun checkPlaceholder() {
        if (usersExercises.isEmpty()) {
            binding.placeholder.visibility = View.VISIBLE
            binding.usersExercises.visibility = View.INVISIBLE
        } else {
            binding.placeholder.visibility = View.INVISIBLE
            binding.usersExercises.visibility = View.VISIBLE
        }
    }
}