package com.example.trainingdiary.ui.adapters.custom_exercise_adapter.inner_custom_exercise_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdiary.R
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.RecyclerviewInnerCustomExercisesBinding

class InnerCustomExerciseAdapter(private val listExercises: List<Exercises>) :
    ListAdapter<Exercises, InnerCustomExerciseAdapter.InnerViewHolder>(InnerDiffUtil()) {

    var onExercisesClick: (exercises: Exercises) -> Unit = { _ -> }

    inner class InnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerviewInnerCustomExercisesBinding.bind(itemView)

        fun onBind(position: Int, exercises: Exercises) {
            binding.textViewNameExercises.text = listExercises[position].name
            itemView.setOnClickListener {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_navigation_exercises_to_infoAboutExercises)
            }
        }
    }

    companion object
    class InnerDiffUtil : DiffUtil.ItemCallback<Exercises>() {
        override fun areItemsTheSame(oldItem: Exercises, newItem: Exercises): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Exercises, newItem: Exercises): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =
            layoutInflater.inflate(R.layout.recyclerview_inner_custom_exercises, parent, false)
        return InnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        val exercises = getItem(position)
        holder.onBind(position, exercises)
    }
}
