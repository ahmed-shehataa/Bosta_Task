package com.ashehata.bosta_task.modules.album_details.domain.repository

import com.ashehata.bosta_task.modules.album_details.domain.model.PhotoDomainModel

interface AlbumDetailsRepository {

    suspend fun getPhotos(albumId: Int, searchTitle: String): List<PhotoDomainModel>

}