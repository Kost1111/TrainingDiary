package com.example.trainingdiary.ui.custom_exercise_adapter.inner_custom_exercise_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdiary.R
import com.example.trainingdiary.data.Exercises
import com.example.trainingdiary.databinding.RecyclerviewInnerCustomExercisesBinding

class InnerCustomExerciseAdapter(private val listExercises: List<Exercises>) :
    ListAdapter<Exercises, InnerCustomExerciseAdapter.InnerViewHolder>(InnerDiffUtil()) {

    inner class InnerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerviewInnerCustomExercisesBinding.bind(itemView)

        fun onBind(position: Int) {
            binding.textViewNameExercises.text = listExercises[position].name
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
        holder.onBind(position)
    }
}
