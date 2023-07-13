package com.example.trainingdiary.ui.fragments.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdiary.R
import com.example.trainingdiary.databinding.FragmentExercisesBinding
import com.example.trainingdiary.ui.fragments.base.BaseFragment
import com.example.trainingdiary.ui.adapters.custom_exercise_adapter.CustomExerciseAdapter
import com.example.trainingdiary.ui.utils.listItem


class ExercisesFragment : BaseFragment<FragmentExercisesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentExercisesBinding =
        FragmentExercisesBinding::inflate
    var liveDataListItems = MutableLiveData(listItem)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPlaceholder()
        val adapter = CustomExerciseAdapter()
        liveDataListItems.observe(viewLifecycleOwner) {
            it.let {
                adapter.submitList(it)
            }
        }
        val onExercisesClick = {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_navigation_exercises_to_infoAboutExercises)
        }
        adapter.onExercisesClick = onExercisesClick
        with(binding) {
            recyclerViewUsersExercises.adapter = adapter
            recyclerViewUsersExercises.layoutManager = LinearLayoutManager(requireContext())
            btnMoreExercises.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_navigation_exercises_to_addNewExercisesFragment)
            }
            btnAddExercises.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_navigation_exercises_to_addNewExercisesFragment)
            }
        }
    }

    private fun checkPlaceholder() {
        if (listItem.isEmpty()) {
            binding.placeholder.visibility = View.VISIBLE
            binding.usersExercises.visibility = View.INVISIBLE
        } else {
            binding.placeholder.visibility = View.INVISIBLE
            binding.usersExercises.visibility = View.VISIBLE
        }
    }
}