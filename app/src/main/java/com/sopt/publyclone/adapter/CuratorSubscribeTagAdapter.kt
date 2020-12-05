package com.sopt.publyclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sopt.publyclone.R
import com.sopt.publyclone.databinding.ItemCuratorProfileTagBinding

class CuratorSubscribeTagAdapter(private val dataList: List<String>) :
    RecyclerView.Adapter<CuratorSubscribeTagAdapter.CuratorSubscribeTagViewHolder>() {
    inner class CuratorSubscribeTagViewHolder(private val binding: ItemCuratorProfileTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.tag = data
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CuratorSubscribeTagViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCuratorProfileTagBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_curator_profile_tag,
            parent,
            false
        )
        return CuratorSubscribeTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuratorSubscribeTagViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size
}