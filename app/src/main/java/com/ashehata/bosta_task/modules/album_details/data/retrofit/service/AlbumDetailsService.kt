package com.ashehata.bosta_task.modules.album_details.data.retrofit.service

import com.ashehata.bosta_task.common.data.retrofit.ApiPaths
import com.ashehata.bosta_task.modules.album_details.data.model.PhotoDataModel
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumDetailsService {

    @GET(ApiPaths.PHOTOS)
    suspend fun getPhotos(@Query("albumId") albumId: Int): List<PhotoDataModel>?
}