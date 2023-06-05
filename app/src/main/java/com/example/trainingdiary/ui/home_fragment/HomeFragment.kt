package com.example.trainingdiary.ui.home_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingdiary.ui.bottom_sheet_fragment.BottomSheetFragment
import com.example.trainingdiary.databinding.FragmentHomeBinding
import com.example.trainingdiary.ui.base_fragment.BaseFragment


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
            BottomSheetFragment().show(requireFragmentManager(), "tag")
        }
    }
}