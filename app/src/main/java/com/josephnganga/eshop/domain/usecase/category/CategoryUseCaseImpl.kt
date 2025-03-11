package com.josephnganga.eshop.domain.usecase.category

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(private val repository: RemoteRepository) :
    CategoryUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return repository.getAllCategoriesListFromApi()
    }
}
