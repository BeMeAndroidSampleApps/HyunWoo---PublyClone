package com.sopt.publyclone.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sopt.publyclone.ui.CuratorFragment
import com.sopt.publyclone.ui.HomeFragment
import com.sopt.publyclone.ui.MyPageFragment
import com.sopt.publyclone.ui.SavedFragment

class BottomNavigationAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount() = 4

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> CuratorFragment()
            2 -> SavedFragment()
            else -> MyPageFragment()
        }
    }
}