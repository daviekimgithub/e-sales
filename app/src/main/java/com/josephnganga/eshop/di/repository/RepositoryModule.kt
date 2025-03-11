package com.josephnganga.eshop.di.repository

import com.josephnganga.eshop.domain.repository.FirebaseRepository
import com.josephnganga.eshop.domain.repository.LocalRepository
import com.josephnganga.eshop.domain.repository.RemoteRepository
import com.josephnganga.eshop.data.repository.FirebaseRepositoryImpl
import com.josephnganga.eshop.data.repository.LocalRepositoryImpl
import com.josephnganga.eshop.data.repository.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        repository: LocalRepositoryImpl,
    ): LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseRepository(
        repository: FirebaseRepositoryImpl,
    ): FirebaseRepository
}
