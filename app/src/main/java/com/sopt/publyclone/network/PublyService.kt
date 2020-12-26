package com.sopt.publyclone.network

import com.sopt.publyclone.model.CuratorProfileFromServer
import retrofit2.Call
import retrofit2.http.GET

interface PublyService {
    @GET("user/subscription")
    fun fetchCurator() : Call<CuratorProfileFromServer>
}