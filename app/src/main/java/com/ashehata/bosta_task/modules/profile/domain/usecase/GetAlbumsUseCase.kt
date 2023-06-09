package com.ashehata.bosta_task.modules.profile.domain.usecase

import com.ashehata.bosta_task.modules.profile.domain.model.AlbumDomainModel
import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel
import com.ashehata.bosta_task.modules.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun execute(userId: Int): List<AlbumDomainModel> {
        return profileRepository.getAlbums(userId)
    }

}