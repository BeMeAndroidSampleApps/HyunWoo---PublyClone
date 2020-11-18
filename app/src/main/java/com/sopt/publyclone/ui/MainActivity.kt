package com.sopt.publyclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.sopt.publyclone.R
import com.sopt.publyclone.adapter.BottomNavigationAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter = BottomNavigationAdapter(supportFragmentManager)
        vp_main.offscreenPageLimit = 2
        vp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bnv_main.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        bnv_main.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.main_home -> vp_main.currentItem = 0
                R.id.main_curator -> vp_main.currentItem = 1
                R.id.main_saved -> vp_main.currentItem = 2
                else -> vp_main.currentItem = 3
            }
            true
        }
    }
}