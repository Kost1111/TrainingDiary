package com.example.trainingdiary.ui.fragments.exercises

import androidx.constraintlayout.motion.utils.ViewState

sealed class ExercisesViewState: ViewState() {

    object None : ExercisesViewState()

    object NoExercises : ExercisesViewState()

    object ContainsExercises : ExercisesViewState()

}