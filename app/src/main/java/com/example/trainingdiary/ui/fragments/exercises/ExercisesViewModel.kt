package com.example.trainingdiary.ui.fragments.exercises

import androidx.lifecycle.ViewModel
import com.example.trainingdiary.ui.utils.listItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ExercisesViewModel : ViewModel() {

    private val _exercisesViewState = MutableStateFlow<ExercisesViewState>(ExercisesViewState.None)
    val exercisesViewState = _exercisesViewState.asStateFlow()

    fun checkPlaceHolder() {
        when (listItem.size) {
            0 -> _exercisesViewState.value = ExercisesViewState.NoExercises

            else -> _exercisesViewState.value = ExercisesViewState.ContainsExercises
        }
    }
}