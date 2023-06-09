package com.ashehata.bosta_task.modules.album_details.data.repository

import com.ashehata.bosta_task.modules.album_details.data.mapper.toDomainModel
import com.ashehata.bosta_task.modules.album_details.data.remote.AlbumDetailsRemoteDataSource
import com.ashehata.bosta_task.modules.album_details.domain.model.PhotoDomainModel
import com.ashehata.bosta_task.modules.album_details.domain.repository.AlbumDetailsRepository
import javax.inject.Inject


class AlbumDetailsRepositoryImpl @Inject constructor(
    private val remote: AlbumDetailsRemoteDataSource
) : AlbumDetailsRepository {

    override suspend fun getPhotos(albumId: Int, searchTitle: String): List<PhotoDomainModel> {
        return remote.getPhotos(albumId, searchTitle).map { it.toDomainModel() }
    }


}