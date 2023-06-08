package com.ashehata.bosta_task.modules.profile.data.remote

import com.ashehata.bosta_task.modules.profile.data.model.AlbumDataModel
import com.ashehata.bosta_task.modules.profile.data.model.UserDataModel

interface ProfileRemoteDataSource {

    suspend fun getUsers(): List<UserDataModel>

    suspend fun getAlbums(userId: Int): List<AlbumDataModel>
}