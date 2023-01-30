package com.example.plantapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.plantapp.R
import com.example.plantapp.databinding.FragmentAddPlantBinding

class AddPlant : Fragment(R.layout.fragment_add_plant) {

    private var _binding : FragmentAddPlantBinding ?=null

    private val binding get() = _binding!!
    private lateinit var viewModel: AddPlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentAddPlantBinding.inflate(inflater, container,false)

        binding.addReminder.setOnClickListener{

            Navigation.findNavController(it).navigate(R.id.action_addPlant_to_reminderSetup)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddPlantViewModel::class.java)

        // TODO: Use the ViewModel
    }

}