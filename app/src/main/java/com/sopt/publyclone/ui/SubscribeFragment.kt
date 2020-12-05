package com.sopt.publyclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sopt.publyclone.R
import com.sopt.publyclone.adapter.CuratorTagAdapter
import com.sopt.publyclone.databinding.FragmentSubscribeBinding
import com.sopt.publyclone.model.CuratorProfileData

class SubscribeFragment(private val curatorProfileData: CuratorProfileData) : Fragment() {
    private lateinit var binding: FragmentSubscribeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subscribe, container, false)
        val tagAdapter = CuratorTagAdapter()
        tagAdapter.replaceList(curatorProfileData.txt_curator_tag)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            curatorData = curatorProfileData
            rvCuratorTag.adapter = tagAdapter
        }
        return binding.root
    }
}