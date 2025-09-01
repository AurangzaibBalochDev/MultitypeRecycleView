package com.zaibtech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zaibtech.multityperecycleview.BannerItem
import com.zaibtech.multityperecycleview.ClothingItem
import com.zaibtech.multityperecycleview.HomeItem
import com.zaibtech.multityperecycleview.R

class MainAdapter(
    private val items: List<HomeItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_BANNER = 0
        private const val VIEW_TYPE_CLOTHING = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is BannerItem -> VIEW_TYPE_BANNER
            is ClothingItem -> VIEW_TYPE_CLOTHING
            else -> throw IllegalArgumentException("Unknown item type at position $position")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_BANNER -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
                BannerViewHolder(view)
            }

            VIEW_TYPE_CLOTHING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.clothing_layout, parent, false)
                ClothingViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BannerViewHolder -> holder.bind(items[position] as BannerItem)
            is ClothingViewHolder -> holder.bind(items[position] as ClothingItem)
        }
    }

    override fun getItemCount(): Int = items.size

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image1: ImageView = itemView.findViewById(R.id.imageView1)
        private val title: TextView = itemView.findViewById(R.id.titleText)

        fun bind(item: BannerItem) {
            image1.setImageResource(item.imageUrl1)
            title.text = item.title
        }
    }

    class ClothingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.imageView)
        private val title: TextView = itemView.findViewById(R.id.titleTextView)
        fun bind(item: ClothingItem) {
            image.setImageResource(item.imageResId)
            title.text = item.title
        }
    }
}
