package com.sopt.publyclone.model

data class CuratorProfileSubscribeData(
    val img_curator_profile_subscribe: Int,
    val txt_curator_name_subscribe: String,
    val txt_curator_workplace_subscribe: String,
    val txt_curator_job_subscribe: String,
    val tag_list: List<String>,
)
