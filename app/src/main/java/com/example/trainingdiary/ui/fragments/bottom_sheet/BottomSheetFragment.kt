package com.example.trainingdiary.ui.fragments.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.trainingdiary.R
import com.example.trainingdiary.databinding.FragmentBottomDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


private const val COLLAPSED_HEIGHT = 228

class BottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBottomDialogBinding
    override fun getTheme() = R.style.AppBottomSheetDialogTheme
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomDialogBinding
            .bind(inflater.inflate(R.layout.fragment_bottom_dialog, container))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val offsetFromTop = 200
        (dialog as? BottomSheetDialog)?.behavior?.apply {
            isFitToContents = false
            expandedOffset = offsetFromTop
            state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onStart() {
        super.onStart()
        val data = arguments?.getString("addWorkout")
        binding.simpleText.text = data
        binding.firstLineSecondBottoFragment.text = arguments?.getString("Test")
        val density = requireContext().resources.displayMetrics.density
        dialog?.let {
            val bottomSheet =
                it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onStateChanged(bottomSheet: View, newState: Int) {}

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    with(binding) {
                        if (slideOffset > 0) {
                            layoutCollapsed.alpha = 1 - 2 * slideOffset
                            layoutExpanded.alpha = slideOffset * slideOffset
                            if (slideOffset > 0.5) {
                                layoutCollapsed.visibility = View.GONE
                                layoutExpanded.visibility = View.VISIBLE
                            }
                            if (slideOffset < 0.5 && binding.layoutExpanded.visibility == View.VISIBLE) {
                                layoutCollapsed.visibility = View.VISIBLE
                                layoutExpanded.visibility = View.INVISIBLE
                            }
                        }
                    }
                }
            })
        }
    }
}