package com.zaibtech.multityperecycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zaibtech.MainAdapter
import com.zaibtech.multityperecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: List<HomeItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        mList = prepareData()

        val adapter = MainAdapter(mList)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun prepareData(): List<HomeItem> {
        val itemList = mutableListOf<HomeItem>()

        itemList.add(
            BannerItem(
                R.drawable.ic_launcher_foreground,
            "Super Sale!"
            )
        )
        itemList.add(
            BannerItem(
                R.drawable.nikeshoes,
            "Super Sale!"
            )
        )
        itemList.add(
            BannerItem(
                R.drawable.mobiles,

            "Super Sale!"
            )
        )
        itemList.add(
            BannerItem(
                R.drawable.ic_launcher_background,

            "Super Sale!"
            )
        )
        itemList.add(
            BannerItem(
                R.drawable.ic_launcher_background,

            "Super Sale!"
            )
        )

        itemList.add(ClothingItem(R.drawable.levis_clothing, "Levis Clothing - Up to 25% off"))
        itemList.add(ClothingItem(R.drawable.women_clothing, "Women Clothing - Up to 30% off"))
        itemList.add(ClothingItem(R.drawable.nikeshoes, "Nike Shoes - Up to 35% off"))

        return itemList
    }




}