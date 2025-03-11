package com.josephnganga.eshop.domain.usecase.favorite

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity
import com.josephnganga.eshop.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : FavoriteUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> =
        repository.getFavoriteProductsFromDb(userId)

    override suspend fun invoke(item: FavoriteProductEntity) {
        repository.insertFavoriteProductToDb(item)
    }
}
