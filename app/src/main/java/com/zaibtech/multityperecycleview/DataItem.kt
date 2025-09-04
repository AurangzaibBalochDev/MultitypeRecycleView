package com.zaibtech.multityperecycleview

interface DataItem
data class WithImageItem(
    val title: String,
    val description: String,
    val image: Int

) : DataItem

data class WithoutImageItem(
    val title: String,
    val description: String,
) : DataItem