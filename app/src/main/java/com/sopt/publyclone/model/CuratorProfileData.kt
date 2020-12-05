package com.sopt.publyclone.model

data class CuratorProfileData(
    val img_curator: Int,
    val txt_curator_name: String,
    val txt_curator_workplace: String,
    val txt_curator_job: String,
    val txt_curator_tag: List<String>
)
