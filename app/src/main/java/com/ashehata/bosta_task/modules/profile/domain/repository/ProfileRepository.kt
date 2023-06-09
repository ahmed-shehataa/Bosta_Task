package com.ashehata.bosta_task.modules.profile.domain.repository

import com.ashehata.bosta_task.modules.profile.domain.model.AlbumDomainModel
import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel

interface ProfileRepository {

    suspend fun getUsers(): List<UserDomainModel>

    suspend fun getAlbums(userId: Int): List<AlbumDomainModel>
}