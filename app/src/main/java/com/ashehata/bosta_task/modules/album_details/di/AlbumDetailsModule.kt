package com.ashehata.bosta_task.modules.album_details.di

import com.ashehata.bosta_task.modules.album_details.data.remote.AlbumDetailsRemoteDataSource
import com.ashehata.bosta_task.modules.album_details.data.remote.AlbumDetailsRemoteDataSourceImpl
import com.ashehata.bosta_task.modules.album_details.data.repository.AlbumDetailsRepositoryImpl
import com.ashehata.bosta_task.modules.album_details.data.retrofit.service.AlbumDetailsService
import com.ashehata.bosta_task.modules.album_details.domain.repository.AlbumDetailsRepository

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class AlbumDetailsModule {

    @ViewModelScoped
    @Binds
    abstract fun bindAlbumDetailsRemoteDataSource(AlbumDetailsRemoteDataSource: AlbumDetailsRemoteDataSourceImpl): AlbumDetailsRemoteDataSource


    @ViewModelScoped
    @Binds
    abstract fun bindAlbumDetailsRepository(AlbumDetailsRepositoryImpl: AlbumDetailsRepositoryImpl): AlbumDetailsRepository


    companion object {
        @ViewModelScoped
        @Provides
        fun provideAlbumDetailsService(retrofit: Retrofit): AlbumDetailsService =
            retrofit.create(AlbumDetailsService::class.java)
    }
}