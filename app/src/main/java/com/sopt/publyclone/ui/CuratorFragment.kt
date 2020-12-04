package com.sopt.publyclone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.MarginPageTransformer
import com.sopt.publyclone.R
import com.sopt.publyclone.databinding.FragmentCuratorBinding
import com.sopt.publyclone.model.CuratorProfileData

class CuratorFragment : Fragment() {
    private lateinit var binding: FragmentCuratorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_curator, container, false)
        val curatorProfileSliderAdapter = CuratorProfileSliderAdapter(getProfileDataList(), this)
        val pageMarginPx = 100
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
                page.translationX = position *- offsetPx
            }
        }
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

    fun getProfileDataList(): List<CuratorProfileData> {
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
}