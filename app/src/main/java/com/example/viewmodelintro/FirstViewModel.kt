package com.example.viewmodelintro

import android.util.Log
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {
    init {
        Log.i("FirstViewModel", "first viewmodel created..")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("FirstViewModel", "viewmodel died")
    }
}