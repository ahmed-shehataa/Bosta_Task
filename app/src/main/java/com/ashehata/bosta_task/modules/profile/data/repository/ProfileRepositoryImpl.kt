package com.ashehata.bosta_task.modules.profile.data.repository

import com.ashehata.bosta_task.modules.profile.data.mapper.toDomainModel
import com.ashehata.bosta_task.modules.profile.data.remote.ProfileRemoteDataSource
import com.ashehata.bosta_task.modules.profile.domain.model.AlbumDomainModel
import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel
import com.ashehata.bosta_task.modules.profile.domain.repository.ProfileRepository
import javax.inject.Inject


class ProfileRepositoryImpl @Inject constructor(
    private val remote: ProfileRemoteDataSource
) : ProfileRepository {

    override suspend fun getUsers(): List<UserDomainModel> {
        return remote.getUsers().map { it.toDomainModel() }
    }

    override suspend fun getAlbums(userId: Int): List<AlbumDomainModel> {
        return remote.getAlbums(userId).map { it.toDomainModel() }
    }

}