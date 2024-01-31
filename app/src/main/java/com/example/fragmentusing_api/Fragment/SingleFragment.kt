package com.example.fragmentusing_api.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentusing_api.FackApplication

import com.example.fragmentusing_api.R
import com.example.fragmentusing_api.databinding.FragmentSingleBinding
import com.example.fragmentusing_api.model.FackDataItem
import com.example.fragmentusing_api.util.NetworkResult
import com.example.fragmentusing_api.viewModel.MainViewModel
import com.example.fragmentusing_api.viewModel.mainViewModelFactory

class singleFragment : Fragment() {
    private var _binding : FragmentSingleBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentSingleBinding.inflate(inflater,container, false)

        val repository = (requireActivity().application as FackApplication).fackRepostory
        mainViewModel = ViewModelProvider(this, mainViewModelFactory(repository)).get(MainViewModel::class.java)

        binding.hi.setOnClickListener {
            mainViewModel.getFackData(5)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.Fack.observe(viewLifecycleOwner, Observer {
//            binding.progressBar.isVisible = false

            when(it){
                is NetworkResult.Success -> {
                    it.data?.let {

                          val getResult = it.toList()
                        Log.d("onViewCreated: ",getResult.toString())
                    }

                    Log.d("onViewCreated: ",it.data.toString())
                }
                is NetworkResult.Error -> {}
                is NetworkResult.Loading -> {
//                    binding.progressBar.isVisible = true
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}