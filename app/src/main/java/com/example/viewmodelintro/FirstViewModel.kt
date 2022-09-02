package com.example.viewmodelintro

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {

    val clicks = MutableLiveData<Int>()
    //val clicks: LiveData<Int> get() = _clicks

    val messages = MutableLiveData<String>()
    //val messages: LiveData<String> get() = _messages

    init {
        clicks.value = 0
        messages.value = ""
        Log.i("FirstViewModel", "first viewmodel created..")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("FirstViewModel", "viewmodel died")
    }

    fun hello(name: String) {
        messages.value = "hi $name"
        clicks.value = clicks.value?.plus(1)
    }
    fun bye(name: String) {
        messages.value = "bye $name"
        clicks.value = clicks.value?.plus(1)
    }
}