package com.ashehata.bosta_task.modules.profile.data.remote


import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel
import com.ashehata.bosta_task.modules.profile.data.retrofit.service.ProfileService
import javax.inject.Inject

class ProfileRemoteDataSourceImpl @Inject constructor(private val service: ProfileService) :
    ProfileRemoteDataSource {
    override suspend fun getAlbums(userId: Int): List<AlbumDataModel> {
        return service.getAlbums(userId).events ?: emptyList()
    }
}