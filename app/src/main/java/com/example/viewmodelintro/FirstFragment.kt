package com.example.viewmodelintro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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

        // observer setting
        viewModel.messages.observe(viewLifecycleOwner, Observer {
            theMessage -> binding.firstFragmentTvMessage.text = theMessage
        })
        viewModel.clicks.observe(viewLifecycleOwner, Observer {
            newClicks -> binding.firstFragmentTvClicks.text = "$newClicks time(s) 클릭"
        })

        // set event listener
        binding.firstFragmentBtHello.setOnClickListener {
            viewModel.hello(binding.firstFragmentEtName.text.toString())
        }
        binding.firstFragmentBtBye.setOnClickListener {
            viewModel.bye(binding.firstFragmentEtName.text.toString())
        }

        return binding.root
    }
    /*
    private fun hello() {
        val yourName = binding.firstFragmentEtName.text.toString()
        viewModel.messages.value = "안녕 $yourName 님"
        viewModel.clicks.value = viewModel.clicks.value?.plus(1)
        Log.i("FirstFragment", viewModel.clicks.value.toString())
        //updateUI()
    }

    private fun bye() {
        val yourName = binding.firstFragmentEtName.text.toString()
        viewModel.messages.value = "잘가요 $yourName 님"
        viewModel.clicks.value = viewModel.clicks.value?.plus(1)
        //updateUI()
    }
    */
//    private fun updateUI() {
//        binding.firstFragmentTvMessage.text = viewModel.messages
//        binding.firstFragmentTvClicks.text = "${viewModel.clicks} time(s) clicked."
//    }

}