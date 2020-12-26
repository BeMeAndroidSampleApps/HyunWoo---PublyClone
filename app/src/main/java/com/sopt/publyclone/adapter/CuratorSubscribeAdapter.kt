package com.sopt.publyclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.sopt.publyclone.R
import com.sopt.publyclone.databinding.ItemCuratorProfileSubscribeBinding
import com.sopt.publyclone.model.CuratorProfileSubscribeData

class CuratorSubscribeAdapter(private val context: Context) :
    RecyclerView.Adapter<CuratorSubscribeAdapter.CuratorSubscribeViewHolder>() {
    private var dataList = mutableListOf<CuratorProfileSubscribeData>()

    inner class CuratorSubscribeViewHolder(private val binding: ItemCuratorProfileSubscribeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(curatorProfileSubscribeData: CuratorProfileSubscribeData) {
            binding.curatorProfileSubscribeData = curatorProfileSubscribeData
            val curatorSubscribeTagAdapter =
                CuratorSubscribeTagAdapter(curatorProfileSubscribeData.tag_list)
            binding.rvCuratorTagSubscribe.apply {
                adapter = curatorSubscribeTagAdapter
                layoutManager = FlexboxLayoutManager(context).apply {
                    flexWrap = FlexWrap.WRAP
                    flexDirection = FlexDirection.ROW
                }
                setHasFixedSize(true)
            }
            curatorSubscribeTagAdapter.notifyDataSetChanged()
        }


        //Exmaple Change
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuratorSubscribeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCuratorProfileSubscribeBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_curator_profile_subscribe,
            parent,
            false
        )
        return CuratorSubscribeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuratorSubscribeViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(newDataList: MutableList<CuratorProfileSubscribeData>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}