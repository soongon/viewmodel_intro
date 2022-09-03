package com.example.viewmodelintro

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {

    private val _clicks = MutableLiveData<Int>()
    val clicks: LiveData<Int> get() = _clicks

    private val _messages = MutableLiveData<String>()
    val messages: LiveData<String> get() = _messages

    init {
        _clicks.value = 0
        _messages.value = ""
        Log.i("FirstViewModel", "first viewmodel created..")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("FirstViewModel", "viewmodel died")
    }

    fun hello(name: String) {
        _messages.value = "hi $name"
        _clicks.value = clicks.value?.plus(1)
    }
    fun bye(name: String) {
        _messages.value = "bye $name"
        _clicks.value = clicks.value?.plus(1)
    }
}