package com.example.viewmodelintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelintro.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)


        return binding.root
    }

}