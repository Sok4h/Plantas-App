package com.example.plantapp.ui.main

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentReminderSetupBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat


class ReminderSetup : BottomSheetDialogFragment(R.layout.fragment_reminder_setup) {

    private var _binding :FragmentReminderSetupBinding ?=null

    private val binding get() = _binding!!

    private val sharedViewModel: PlantViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentReminderSetupBinding.inflate(inflater,container,false)

        binding.task.setOnClickListener{

            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView).navigate(R.id.action_reminderSetup_to_actityOptions)

        }

        binding.time.setOnClickListener{

//            Navigation.findNavController(requireActivity(),R.id.fragmentContainerView).navigate(R.id.)

            openTimePicker()
        }

        sharedViewModel.activity.observe(viewLifecycleOwner) {

        binding.taskTV.text=it
        }
        return binding.root
    }

    private fun openTimePicker() {

        val isSystem24Hour = DateFormat.is24HourFormat(requireContext())
        val clockFormat = if(isSystem24Hour) TimeFormat.CLOCK_24H else TimeFormat.CLOCK_12H
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(clockFormat)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Set reminder time")
            .build()
        picker.show(parentFragmentManager,"tag")

        picker.addOnPositiveButtonClickListener {

            val minutes = picker.minute
            val hour = picker.hour

            Log.e("TAG", "$hour:$minutes")

        binding.timeTv.text = "$hour : $minutes"
        }

    }




}