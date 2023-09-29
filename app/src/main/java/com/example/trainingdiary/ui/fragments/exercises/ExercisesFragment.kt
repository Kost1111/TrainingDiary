package com.example.trainingdiary.ui.fragments.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trainingdiary.R
import com.example.trainingdiary.databinding.FragmentExercisesBinding
import com.example.trainingdiary.ui.fragments.base.BaseFragment
import com.example.trainingdiary.ui.adapters.custom_exercise_adapter.CustomExerciseAdapter
import com.example.trainingdiary.ui.utils.invisible
import com.example.trainingdiary.ui.utils.launchWhenStarted
import com.example.trainingdiary.ui.utils.listItem
import com.example.trainingdiary.ui.utils.navigateToBack
import com.example.trainingdiary.ui.utils.visible
import kotlinx.coroutines.flow.onEach


class ExercisesFragment : BaseFragment<FragmentExercisesBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentExercisesBinding =
        FragmentExercisesBinding::inflate
    private var liveDataListItems = MutableLiveData(listItem)

    private lateinit var exercisesViewModel: ExercisesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exercisesViewModel = ViewModelProvider(this)[ExercisesViewModel::class.java]
        exercisesViewModel.checkPlaceHolder()
        with(exercisesViewModel) {
            exercisesViewState
                .onEach(::render)
                .launchWhenStarted(lifecycleScope)
        }
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

    private fun <T> render(state: T) where T : ViewState {
        when (state) {
            is ExercisesViewState.NoExercises -> {
                showPlaceHolder()
            }

            is ExercisesViewState.ContainsExercises -> {
                notShowPlaceHolder()
            }
        }
    }

    private fun setupAdapter(adapter: CustomExerciseAdapter) = with(binding) {
        recyclerViewUsersExercises.adapter = adapter
        recyclerViewUsersExercises.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showPlaceHolder() = with(binding) {
        placeholder.visible()
        usersExercises.invisible()
    }

    private fun notShowPlaceHolder() = with(binding) {
        placeholder.invisible()
        usersExercises.visible()
    }
}