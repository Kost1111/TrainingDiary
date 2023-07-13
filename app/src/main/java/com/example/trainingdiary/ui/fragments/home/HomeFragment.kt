package com.example.trainingdiary.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.trainingdiary.R
import com.example.trainingdiary.databinding.FragmentHomeBinding
import com.example.trainingdiary.ui.fragments.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) ->
    FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = (dayOfMonth.toString() + "-"
                    +(month + 1) + "-" + year)
            val bundle = Bundle()
            bundle.putString("Test",date)
//            BottomSheetFragment().arguments?.putString("addWorkout",date)
//            BottomSheetFragment().show(requireFragmentManager(), "tag")
            Navigation.findNavController(binding.root).navigate(R.id.bottomSheetFragment,bundle)
        }
    }
}