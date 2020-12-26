package com.sopt.publyclone.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CuratorProfileFromServer(
    @Json(name = "data")
    val datas: List<Data>,
    @Json(name = "message")
    val message: String,
    @Json(name = "status")
    val status: Int,
    @Json(name = "success")
    val success: Boolean
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "company")
    val company: String,
    @Json(name = "ifNew")
    val ifNew: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "profileUrl")
    val profileUrl: String,
    @Json(name = "role")
    val role: String,
    @Json(name = "tag")
    val tag: List<String>
)