package com.ashehata.bosta_task.modules.album_details.data.remote

import com.ashehata.bosta_task.modules.album_details.data.model.PhotoDataModel
import com.ashehata.bosta_task.modules.album_details.data.retrofit.service.AlbumDetailsService
import javax.inject.Inject

class AlbumDetailsRemoteDataSourceImpl @Inject constructor(
    private val service: AlbumDetailsService
) : AlbumDetailsRemoteDataSource {

    override suspend fun getPhotos(albumId: Int): List<PhotoDataModel> {
        return service.getPhotos(albumId) ?: emptyList()
    }
}