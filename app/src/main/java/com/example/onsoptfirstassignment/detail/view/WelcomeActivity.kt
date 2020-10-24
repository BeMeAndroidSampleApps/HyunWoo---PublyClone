package com.example.onsoptfirstassignment.detail.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onsoptfirstassignment.R
import com.example.onsoptfirstassignment.databinding.ActivityWelcomeBinding
import com.example.onsoptfirstassignment.detail.model.ProjectData
import com.example.onsoptfirstassignment.detail.recyclerview.BaseRecyclerView
import com.example.onsoptfirstassignment.detail.recyclerview.ProjectAdapter
import com.example.onsoptfirstassignment.detail.viewmodel.WelcomeViewModel

class WelcomeActivity : AppCompatActivity() {
    private val welcomeViewModel: WelcomeViewModel by viewModels()
    private lateinit var binding: ActivityWelcomeBinding
    var data = mutableListOf<ProjectData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.welcomeViewModel = welcomeViewModel
        binding.lifecycleOwner = this

        val adapter = ProjectAdapter(this)
        addData()
        adapter.datas = data
        adapter.notifyDataSetChanged()
        binding.recyclerviewProject.adapter = adapter

        welcomeViewModel.floatingButtonClickListener.observe(this, {
            if(it) {
                welcomeViewModel.isLinearLayout.value?.let { isLinearLayout ->
                    changeLayout(isLinearLayout)
                }
                "레이아웃 변경".toast()
                welcomeViewModel.setFloatingButtonClickEventFalse()
            }
        })

        welcomeViewModel.isLinearLayout.observe(this, { isLinearLayout ->
            if(isLinearLayout) {

            } else {

            }
        })
    }

    private fun addData() {
        data.apply {
            add(
                ProjectData(
                    img_portfolio = R.drawable.ounce_logo,
                    txt_title = "OUNCE",
                    txt_explain = "온스(OUNCE)는 제가 참여했던 26기 SOPT APP-JAM에서 " +
                            "제작한 어플리케이션입니다. 저는 민구형과 주예랑 함께 안드로이드 " +
                            "개발 파트에서 작업을 했습니다."
                )
            )
            add(
                ProjectData(
                    img_portfolio = R.drawable.maru_logo,
                    txt_title = "마루",
                    txt_explain = "마루는 OUNCE의 구성원로 구성된 사이드 프로젝트입니다. " +
                            "온라인 독서토론 어플리케이션으로 저는 안드로이드 개발 및 기획에 " +
                            "참여했습니다."
                )
            )
            add(
                ProjectData(
                    img_portfolio = R.drawable.sopt_spring,
                    txt_title = "충무로 스프링 스터디",
                    txt_explain = "SOPT에 들어와서 참여하게 된 첫 스터디로 " +
                            "동관/경선/혜선/민지와 함께 즐거운 스프링 공부를 했습니다. " +
                            "SOPT 선정 스터디 1위도 했었습니다."
                )

            )
            add(
                ProjectData(
                    img_portfolio = R.drawable.android_siba,
                    txt_title = "안드로이드 심화 스터디 : SIBA",
                    txt_explain = "안드로이드를 더 깊이 공부하기 위한 4인방 " +
                            "김영민/송훈기/이현우/박진수의 환장 콜라보 " +
                            "매일매일 모각공 및 자료 공유 활성화"
                )
            )
            add(
                ProjectData(
                    img_portfolio = R.drawable.kotlin,
                    txt_title = "안드로이드 Kotlin 스터디",
                    txt_explain = "처음 안드로이드를 접한 OB들의 초보 탈출기 " +
                            "3주간의 인텐시브 트레이닝으로 코틀린 격파"
                )
            )
        }
    }

    private fun changeLayout(isLinearLayout : Boolean) {
        if(isLinearLayout) {
            welcomeViewModel.linearToGrid()
        } else {
            welcomeViewModel.gridToLinear()
        }
    }

    private fun String.toast() {
        Toast.makeText(this@WelcomeActivity, this, Toast.LENGTH_SHORT).show()
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        @BindingAdapter("replaceAll")
        @JvmStatic
        fun RecyclerView.replaceAll(list: List<Any>?) {
            (this.adapter as? BaseRecyclerView.BaseAdapter<Any, *>?)?.run {
                replaceAll(list)
                notifyDataSetChanged()
            }
        }
    }
}