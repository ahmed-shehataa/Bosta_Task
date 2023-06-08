package com.ashehata.bosta_task.modules.profile.domain.usecase

import com.ashehata.bosta_task.modules.profile.domain.model.UserDomainModel
import com.ashehata.bosta_task.modules.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun execute(): List<UserDomainModel> {
        return profileRepository.getUsers()
    }

}