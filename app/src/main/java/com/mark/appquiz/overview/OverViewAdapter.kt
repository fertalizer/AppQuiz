package com.mark.appquiz.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mark.appquiz.data.OverviewData
import com.mark.appquiz.databinding.ItemOverviewType1Binding
import com.mark.appquiz.databinding.ItemOverviewType2Binding

private const val ITEM_VIEW_TYPE_ONE = 0
private const val ITEM_VIEW_TYPE_TWO = 1
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

    class Type2ViewHolder(private val binding: ItemOverviewType2Binding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(overviewData: OverviewData) {
            binding.overviewData = overviewData
//            if (overviewData.tags.size > 2) {
//                binding.type1Tag1.visibility = View.VISIBLE
//                binding.type1Tag2.visibility = View.VISIBLE
//                binding.type1Tag3.visibility = View.VISIBLE
//                binding.type1Tag1.text = overviewData.tags[0]
//                binding.type1Tag2.text = overviewData.tags[1]
//                binding.type1Tag3.text = overviewData.tags[2]
//            } else if (overviewData.tags.size > 1) {
//                binding.type1Tag1.visibility = View.VISIBLE
//                binding.type1Tag2.visibility = View.VISIBLE
//                binding.type1Tag1.text = overviewData.tags[0]
//                binding.type1Tag2.text = overviewData.tags[1]
//            } else if(overviewData.tags.size > 0) {
//                binding.type1Tag1.visibility = View.VISIBLE
//                binding.type1Tag1.text = overviewData.tags[0]
//            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            ITEM_VIEW_TYPE_ONE ->
                Type1ViewHolder(ItemOverviewType1Binding.inflate(layoutInflater, parent, false))
            ITEM_VIEW_TYPE_TWO ->
                Type2ViewHolder(ItemOverviewType2Binding.inflate(layoutInflater, parent, false))
            else ->
                throw ClassCastException("Unknown viewType ${viewType}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val overviewData = getItem(position)
        when(holder) {
            is Type1ViewHolder -> holder.bind(overviewData)
            is Type2ViewHolder -> holder.bind(overviewData)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getItem(position).imageUrls.size > 1) {
            return ITEM_VIEW_TYPE_TWO
        } else {
            return ITEM_VIEW_TYPE_ONE
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

