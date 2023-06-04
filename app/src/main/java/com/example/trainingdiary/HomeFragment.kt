package com.example.trainingdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.trainingdiary.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = (dayOfMonth.toString() + "-"
                    + (month + 1) + "-" + year)
            val bundle = Bundle()
            bundle.putString("addWorkout",date)
            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_home_to_addWorkoutFragment,bundle)
        }
    }

}