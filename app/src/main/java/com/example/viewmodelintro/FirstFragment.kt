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

    // private var clicks = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        // set event listener
        binding.firstFragmentBtHello.setOnClickListener { hello() }
        binding.firstFragmentBtBye.setOnClickListener { bye() }

        return binding.root
    }
    private fun hello() {
        val yourName = binding.firstFragmentEtName.text.toString()
        viewModel.messages = "안녕 $yourName 님"
        viewModel.clicks++
        updateUI()
    }

    private fun bye() {
        val yourName = binding.firstFragmentEtName.text.toString()
        viewModel.messages = "잘가요 $yourName 님"
        viewModel.clicks++
        updateUI()
    }
    private fun updateUI() {
        binding.firstFragmentTvMessage.text = viewModel.messages
        binding.firstFragmentTvClicks.text = "${viewModel.clicks} time(s) clicked."
    }

}