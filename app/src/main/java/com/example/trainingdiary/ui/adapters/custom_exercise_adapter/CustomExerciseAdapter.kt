package com.example.trainingdiary.ui.adapters.custom_exercise_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdiary.R
import com.example.trainingdiary.data.CustomExercises
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.RecyclerviewCustomExercisesBinding
import com.example.trainingdiary.ui.adapters.custom_exercise_adapter.inner_custom_exercise_adapter.InnerCustomExerciseAdapter

class CustomExerciseAdapter :
    ListAdapter<CustomExercises, CustomExerciseAdapter.ViewHolder>(CustomExercisesDiffUtil()) {

    var onExercisesClick: () -> Unit = { }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerviewCustomExercisesBinding.bind(itemView)

        fun onBind(customExercises: CustomExercises, position: Int) {
            binding.titleCard.text = customExercises.title
            val adapter = InnerCustomExerciseAdapter(customExercises.Exercises)
            val exercises: Exercises = customExercises.Exercises[position]
            val onItemClick = { _: Exercises ->
                onExercisesClick
                Unit
            }
            adapter.onExercisesClick = onItemClick
            adapter.submitList(customExercises.Exercises)
            binding.recyclerViewCustomExercises.addItemDecoration(
                DividerItemDecoration(
                    binding.recyclerViewCustomExercises.context,
                    DividerItemDecoration.VERTICAL
                )
            )
            binding.recyclerViewCustomExercises.adapter = adapter
            binding.recyclerViewCustomExercises.layoutManager =
                LinearLayoutManager(itemView.context)
        }


    }


    companion object {
        class CustomExercisesDiffUtil : DiffUtil.ItemCallback<CustomExercises>() {
            override fun areItemsTheSame(
                oldItem: CustomExercises,
                newItem: CustomExercises
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CustomExercises,
                newItem: CustomExercises
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recyclerview_custom_exercises, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customExercises = getItem(position)
        holder.onBind(customExercises, position)
    }
}
