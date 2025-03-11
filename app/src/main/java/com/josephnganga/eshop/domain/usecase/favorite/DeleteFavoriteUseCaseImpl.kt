package com.josephnganga.eshop.domain.usecase.favorite

import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity
import com.josephnganga.eshop.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteFavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : DeleteFavoriteUseCase {
    override suspend fun invoke(favoriteProductEntity: FavoriteProductEntity) {
        repository.deleteFavoriteProduct(favoriteProductEntity)
    }
}
