package com.ashehata.bosta_task.modules.profile.data.retrofit.service

import com.ashehata.bosta_task.common.data.retrofit.ApiPaths
import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel
import com.ashehata.bosta_task.modules.profile.data.model.UserDataModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ProfileService {

    @GET(ApiPaths.ALBUMS)
    suspend fun getAlbums(@Query("userId") userId: Int): List<AlbumDataModel>?

    @GET(ApiPaths.USERS)
    suspend fun getUsers(): List<UserDataModel>?

}