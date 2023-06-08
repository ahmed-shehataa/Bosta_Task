package com.ashehata.bosta_task.modules.profile.data.retrofit.service

import com.ashehata.bosta_task.common.data.retrofit.ApiPaths
import com.ashehata.bosta_task.modules.profile.data.retrofit.response.AlbumsListResponse
import com.ashehata.bosta_task.modules.profile.data.retrofit.response.UsersListResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ProfileService {

    @GET(ApiPaths.ALBUMS)
    suspend fun getAlbums(@Query("userId") userId: Int): AlbumsListResponse

    @GET(ApiPaths.USERS)
    suspend fun getUsers(): List<UsersListResponse>

}