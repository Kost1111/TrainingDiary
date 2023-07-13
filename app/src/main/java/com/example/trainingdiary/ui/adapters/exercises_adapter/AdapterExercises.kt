package com.example.trainingdiary.ui.adapters.exercises_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingdiary.R
import com.example.trainingdiary.data.Exercises

class AdapterExercises :
    ListAdapter<Exercises, AdapterExercises.ExercisesVieHolder>(ExercisesDiffUtil()) {
    var onItemClickCallBack: (exercises: Exercises) -> Unit = { _ -> }

    inner class ExercisesVieHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(exercises: Exercises) {
            val textView: TextView = itemView.findViewById(R.id.tvAddExercises)
            textView.text = exercises.name
            itemView.setOnClickListener {
                onItemClickCallBack(exercises)
            }
        }
    }

    companion object {
        class ExercisesDiffUtil : DiffUtil.ItemCallback<Exercises>() {
            override fun areItemsTheSame(oldItem: Exercises, newItem: Exercises): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Exercises, newItem: Exercises): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesVieHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recyclerview_all_exercises_item, parent, false)
        return ExercisesVieHolder(view = view)
    }

    override fun onBindViewHolder(holder: ExercisesVieHolder, position: Int) {
        val exercises = getItem(position)
        holder.onBind(exercises)
    }
}

