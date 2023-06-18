package com.example.trainingdiary.ui.add_new_exercises_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdiary.R
import com.example.trainingdiary.data.CustomExercises
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.FragmentAddNewExercisesBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment
import com.example.trainingdiary.ui.exercises_adapter.AdapterExercises
import com.example.trainingdiary.utils.BACK
import com.example.trainingdiary.utils.BICEPS
import com.example.trainingdiary.utils.BREAST
import com.example.trainingdiary.utils.DELTA
import com.example.trainingdiary.utils.LEGS
import com.example.trainingdiary.utils.TRICEPS
import com.example.trainingdiary.utils.allExercises
import com.example.trainingdiary.utils.backExercises
import com.example.trainingdiary.utils.bicepsExercises
import com.example.trainingdiary.utils.breastExercises
import com.example.trainingdiary.utils.deltaExercises
import com.example.trainingdiary.utils.legsExercises
import com.example.trainingdiary.utils.listItem
import com.example.trainingdiary.utils.tricepsExercises
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
        val onItemClick = { exercises: Exercises ->
            addExercisesToMutableList(exercises)
            adapter.submitList(allExercises.toList())
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_addNewExercisesFragment_to_navigation_exercises)
        }

        adapter.onItemClickCallBack = onItemClick
        adapter.submitList(allExercises.toList())
        binding.recyclerViewAllExercises.adapter = adapter
        binding.recyclerViewAllExercises.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addExercisesToMutableList(exercises: Exercises) {
        when (exercises.muscleGroup) {
            TRICEPS -> checkList(tricepsExercises, exercises)
            LEGS -> checkList(legsExercises, exercises)
            BICEPS -> checkList(bicepsExercises, exercises)
            BREAST -> checkList(breastExercises, exercises)
            BACK -> checkList(backExercises,exercises)
            DELTA -> checkList(deltaExercises, exercises)
        }
    }

    private fun checkList(list: MutableList<Exercises>, exercises: Exercises) {
        if (list.isEmpty()) {
            list.add(exercises)
            listItem.add(CustomExercises(exercises.muscleGroup, list))
        } else {
            list.add(exercises)
        }
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