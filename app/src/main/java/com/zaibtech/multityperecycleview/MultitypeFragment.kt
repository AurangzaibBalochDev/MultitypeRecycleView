package com.zaibtech.multityperecycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaibtech.multityperecycleview.databinding.FragmentMultitypeBinding

class MultitypeFragment : Fragment() {

    private lateinit var binding: FragmentMultitypeBinding
    private lateinit var itemList: List<DataItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMultitypeBinding.inflate(inflater, container, false)
        binding.goToSlidder.setOnClickListener {
            it.findNavController().navigate(R.id.action_multitypeFragment_to_imageSlider)
        }

        itemList = prepareDataForNote()

        binding.recv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val adapter = MainAdapter(itemList)
        binding.recv.adapter = adapter

        return binding.root
    }

    private fun prepareDataForNote(): List<DataItem> {
        val itemList = mutableListOf<DataItem>()
        itemList.add(WithImageItem("title8", "desc8",R.drawable.image1))
        itemList.add(WithImageItem("title9", "desc8",R.drawable.image2))
        itemList.add(WithoutImageItem("title1", "desc1"))
        itemList.add(WithoutImageItem("title2", "desc2"))
        itemList.add(WithoutImageItem("title3", "desc3"))
        itemList.add(WithoutImageItem("title4", "desc4"))
        itemList.add(WithoutImageItem("title5", "desc5"))
        itemList.add(WithoutImageItem("title6", "desc6"))
        itemList.add(WithoutImageItem("title7", "desc7"))
        itemList.add(WithoutImageItem("title8", "desc8"))
        itemList.add(WithoutImageItem("title8", "desc8"))
        itemList.add(WithoutImageItem("title8", "desc8"))


        return itemList
    }

}