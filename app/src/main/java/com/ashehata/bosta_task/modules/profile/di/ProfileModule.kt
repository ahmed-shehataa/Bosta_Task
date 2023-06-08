package com.ashehata.bosta_task.modules.profile.di

import com.ashehata.bosta_task.modules.profile.data.remote.ProfileRemoteDataSource
import com.ashehata.bosta_task.modules.profile.data.remote.ProfileRemoteDataSourceImpl
import com.ashehata.bosta_task.modules.profile.data.repository.ProfileRepositoryImpl
import com.ashehata.bosta_task.modules.profile.data.retrofit.service.ProfileService
import com.ashehata.bosta_task.modules.profile.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProfileModule {

    @ViewModelScoped
    @Binds
    abstract fun bindProfileRemoteDataSource(ProfileRemoteDataSource: ProfileRemoteDataSourceImpl): ProfileRemoteDataSource


    @ViewModelScoped
    @Binds
    abstract fun bindProfileRepository(ProfileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository


    companion object {
        @ViewModelScoped
        @Provides
        fun provideProfileService(retrofit: Retrofit): ProfileService =
            retrofit.create(ProfileService::class.java)
    }
}