package com.example.plantapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlantViewModel:ViewModel() {

    private val _hour = MutableLiveData<Int>(0)
    val hour: LiveData<Int> = _hour

    private val _minute = MutableLiveData<Int>(0)
    val minute: LiveData<Int> = _minute

    private val _activity = MutableLiveData("Regar")
    val activity: LiveData<String> = _activity

    fun setActivity(activity: String) {
        _activity.value = activity
    }

}