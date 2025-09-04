package com.zaibtech.multityperecycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.zaibtech.multityperecycleview.databinding.FragmentMainBinding


class MainFragment : Fragment() {
private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.goToMultitype.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_multitypeFragment)
        }
        return binding.root
    }
}