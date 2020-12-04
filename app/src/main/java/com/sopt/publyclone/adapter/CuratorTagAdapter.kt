package com.sopt.publyclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sopt.publyclone.R
import com.sopt.publyclone.databinding.ItemCuratorProfileTagBinding

class CuratorTagAdapter :
    RecyclerView.Adapter<CuratorTagAdapter.CuratorTagViewHolder>() {
    private var dataList = mutableListOf<String>()

    inner class CuratorTagViewHolder(private val binding: ItemCuratorProfileTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(tag: String) {
            binding.tag = tag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorTagViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCuratorProfileTagBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_curator_profile_tag,
            parent,
            false
        )
        return CuratorTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuratorTagViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(list: List<String>) {
        dataList = list.toMutableList()
        notifyDataSetChanged()
    }
}