package com.sopt.publyclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.sopt.publyclone.R
import com.sopt.publyclone.adapter.CuratorSubscribeAdapter
import com.sopt.publyclone.databinding.FragmentCuratorBinding
import com.sopt.publyclone.model.CuratorProfileData
import com.sopt.publyclone.model.CuratorProfileSubscribeData

class CuratorFragment : Fragment() {
    private lateinit var binding: FragmentCuratorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curator, container, false)
        val curatorProfileSliderAdapter = CuratorProfileSliderAdapter(getProfileDataList(), this)
        val curatorSubscribeAdapter = CuratorSubscribeAdapter(requireContext())

        val pageMarginPx = 125
        val pagerWidth = 1000
        val screenWidth = resources.displayMetrics.widthPixels
        val offsetPx = screenWidth - pageMarginPx - pagerWidth
        binding.vpCuratorCurator.apply {
            adapter = curatorProfileSliderAdapter
            setPadding(50, 0, 50, 0)
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            setPageTransformer { page, position ->
                page.translationX = position * -offsetPx
            }
        }

        binding.rvCuratorCurator.apply {
            adapter = curatorSubscribeAdapter
            setHasFixedSize(true)
        }
        curatorSubscribeAdapter.replaceList(getSubscribeProfileDataList().toMutableList())
        return binding.root
    }

    private inner class CuratorProfileSliderAdapter(
        private var curatorProfileData: List<CuratorProfileData>,
        fragment: Fragment
    ) : FragmentStateAdapter(fragment) {
        override fun getItemCount() = curatorProfileData.size

        override fun createFragment(position: Int): Fragment =
            SubscribeFragment(curatorProfileData[position])

    }

    private fun getProfileDataList(): List<CuratorProfileData> {
        val profileList = mutableListOf<CuratorProfileData>()
        profileList.apply {
            add(
                CuratorProfileData(
                    img_curator = R.drawable.img_profile_dummy,
                    txt_curator_name = "이현우",
                    txt_curator_workplace = "Google",
                    txt_curator_job = "Android Developer",
                    txt_curator_tag = listOf("플랫폼 디자이너", "뭘 쓰지", "아몰랑")
                )
            )
            add(
                CuratorProfileData(
                    img_curator = R.drawable.img_profile_dummy,
                    txt_curator_name = "이현우",
                    txt_curator_workplace = "Google",
                    txt_curator_job = "Android Developer",
                    txt_curator_tag = listOf("플랫폼 디자이너", "뭘 쓰지", "아몰랑")
                )
            )
            add(
                CuratorProfileData(
                    img_curator = R.drawable.img_profile_dummy,
                    txt_curator_name = "이현우",
                    txt_curator_workplace = "Google",
                    txt_curator_job = "Android Developer",
                    txt_curator_tag = listOf("플랫폼 디자이너", "뭘 쓰지", "아몰랑")
                )
            )
            add(
                CuratorProfileData(
                    img_curator = R.drawable.img_profile_dummy,
                    txt_curator_name = "이현우",
                    txt_curator_workplace = "Google",
                    txt_curator_job = "Android Developer",
                    txt_curator_tag = listOf("플랫폼 디자이너", "뭘 쓰지", "아몰랑")
                )
            )
        }
        return profileList
    }

    private fun getSubscribeProfileDataList(): List<CuratorProfileSubscribeData> {
        val subscribeProfileDataList = mutableListOf<CuratorProfileSubscribeData>()
        subscribeProfileDataList.apply {
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
            add(
                CuratorProfileSubscribeData(
                    img_curator_profile_subscribe = R.drawable.img_profile_dummy,
                    txt_curator_name_subscribe = "이현우",
                    txt_curator_workplace_subscribe = "Google",
                    txt_curator_job_subscribe = "Growth Manager",
                    tag_list = listOf("플랫폼 디자이너", "뭘 쓰지", "그로스마케터가 되고 싶습니다")
                )
            )
        }
        return subscribeProfileDataList
    }
}