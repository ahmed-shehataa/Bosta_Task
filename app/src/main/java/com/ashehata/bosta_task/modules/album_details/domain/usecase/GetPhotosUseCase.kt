package com.ashehata.bosta_task.modules.album_details.domain.usecase

import com.ashehata.bosta_task.modules.album_details.domain.model.PhotoDomainModel
import com.ashehata.bosta_task.modules.album_details.domain.repository.AlbumDetailsRepository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val albumDetailsRepository: AlbumDetailsRepository
) {

    suspend fun execute(
        albumId: Int,
        searchTitle: String = ""
    ): List<PhotoDomainModel> {
        return albumDetailsRepository.getPhotos(albumId, searchTitle)
    }

}