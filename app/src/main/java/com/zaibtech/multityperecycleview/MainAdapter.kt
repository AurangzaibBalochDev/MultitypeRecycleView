package com.zaibtech.multityperecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val items: List<DataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val IS_WITH_IMAGE = 0
        private const val IS_WITHOUT_IMAGE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is WithImageItem -> IS_WITH_IMAGE
            is WithoutImageItem -> IS_WITHOUT_IMAGE
            else -> throw IllegalArgumentException("Unkown Item Type ")
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        return when (viewType) {
            IS_WITH_IMAGE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.with_image, parent, false)
                return WithImageViewHolder(view)
            }

            IS_WITHOUT_IMAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.without_image, parent, false)
                return WithoutImageViewHolder(view)
            }


            else -> throw IllegalArgumentException("type not found")

        }
    }


    class WithImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title_text)
        private val desc: TextView = itemView.findViewById(R.id.decText)
        private val image: ImageView = itemView.findViewById(R.id.image_view)

        fun bind(item: WithImageItem) {
            title.text = item.title
            desc.text = item.description
            image.setImageResource(item.image)
        }
    }

    class WithoutImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleText: TextView = itemView.findViewById(R.id.stitle_text)
        private val descText: TextView = itemView.findViewById(R.id.sdecText)

        fun bind(item: WithoutImageItem) {
            titleText.text = item.title
            descText.text = item.description
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is WithImageViewHolder -> holder.bind(items[position] as WithImageItem)
            is WithoutImageViewHolder -> holder.bind(items[position] as WithoutImageItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}


