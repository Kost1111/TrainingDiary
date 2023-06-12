package com.example.trainingdiary.ui.add_new_exercises_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdiary.R
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.FragmentAddNewExercisesBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.ui.exercises_adapter.AdapterExercises
import com.example.trainingdiary.utils.allExercises
import com.example.trainingdiary.utils.usersExercises
import java.util.*

class AddNewExercisesFragment : BaseFragment<FragmentAddNewExercisesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentAddNewExercisesBinding =
        FragmentAddNewExercisesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = AdapterExercises()

        binding.searchViewAllExercises.addTextChangedListener { text ->
            filter(text.toString(), adapter)
        }
        val onItemClick = {exercises: Exercises ->
            usersExercises.add(exercises)
            adapter.submitList(allExercises.toList())
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_addNewExercisesFragment_to_navigation_exercises)
        }
        adapter.onItemClickCallBack = onItemClick
        adapter.submitList(allExercises.toList())
        binding.recyclerViewAllExercises.adapter = adapter
        binding.recyclerViewAllExercises.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun filter(text: String, adapter: AdapterExercises) {
        val exercisesList = arrayListOf<Exercises>()
        for (i in allExercises) {
            if (i.name.lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault()))
            ) {
                exercisesList.add(i)
            }
            // дописать фрагмент "добавить упражнение"
        }
        adapter.submitList(exercisesList.toList())
    }

}