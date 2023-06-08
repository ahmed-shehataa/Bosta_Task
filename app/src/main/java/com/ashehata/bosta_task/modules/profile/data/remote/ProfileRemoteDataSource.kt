package com.ashehata.bosta_task.modules.profile.data.remote

import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel

interface ProfileRemoteDataSource {
    suspend fun getAlbums(userId: Int): List<AlbumDataModel>
}