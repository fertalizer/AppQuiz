package com.mark.appquiz.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mark.appquiz.data.Item
import com.mark.appquiz.data.OverviewData
import com.mark.appquiz.databinding.ItemOverviewType1Binding

class OverViewAdapter: ListAdapter<OverviewData, RecyclerView.ViewHolder>(DiffCallback){

    class Type1ViewHolder(private val binding: ItemOverviewType1Binding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(overviewData: OverviewData) {
            binding.overviewData = overviewData
            if (overviewData.tags.size > 2) {
                binding.type1Tag1.visibility = View.VISIBLE
                binding.type1Tag2.visibility = View.VISIBLE
                binding.type1Tag3.visibility = View.VISIBLE
                binding.type1Tag1.text = overviewData.tags[0]
                binding.type1Tag2.text = overviewData.tags[1]
                binding.type1Tag3.text = overviewData.tags[2]
            } else if (overviewData.tags.size > 1) {
                binding.type1Tag1.visibility = View.VISIBLE
                binding.type1Tag2.visibility = View.VISIBLE
                binding.type1Tag1.text = overviewData.tags[0]
                binding.type1Tag2.text = overviewData.tags[1]
            } else if(overviewData.tags.size > 0) {
                binding.type1Tag1.visibility = View.VISIBLE
                binding.type1Tag1.text = overviewData.tags[0]
            }
            binding.executePendingBindings()
        }
    }

    class Type2ViewHolder() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return Type1ViewHolder(ItemOverviewType1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val overviewData = getItem(position)
        when(holder) {
            is Type1ViewHolder -> holder.bind(overviewData)
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<OverviewData>() {
        override fun areItemsTheSame(oldItem: OverviewData, newItem: OverviewData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: OverviewData, newItem: OverviewData): Boolean {
            return oldItem.id == newItem.id
        }
    }
}

