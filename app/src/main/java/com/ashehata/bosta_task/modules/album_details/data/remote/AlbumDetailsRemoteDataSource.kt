package com.ashehata.bosta_task.modules.album_details.data.remote

import com.ashehata.bosta_task.modules.album_details.data.model.PhotoDataModel

interface AlbumDetailsRemoteDataSource {

    suspend fun getPhotos(albumId: Int): List<PhotoDataModel>
}