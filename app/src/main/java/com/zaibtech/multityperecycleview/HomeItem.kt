package com.zaibtech.multityperecycleview

// Base Interface (optional, just for consistency)
interface HomeItem

data class BannerItem(val imageUrl1: Int, val title: String) : HomeItem

data class ClothingItem(val imageResId: Int, val title: String) : HomeItem
