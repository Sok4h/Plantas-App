package com.example.plantapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentActityOptionsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ActityOptions : BottomSheetDialogFragment(R.layout.fragment_actity_options) {

    private val sharedViewModel: PlantViewModel by activityViewModels()

    private var _binding:FragmentActityOptionsBinding?=null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentActityOptionsBinding.inflate(inflater, container,false)
        binding.watering.setOnClickListener {

            sharedViewModel.setActivity("Regar")
            dismiss()
        }

        binding.fertilize.setOnClickListener {

            sharedViewModel.setActivity("Fertilizar")
            dismiss()
        }


        return binding.root
    }



}