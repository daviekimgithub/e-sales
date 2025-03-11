package com.josephnganga.eshop.domain.usecase.favorite

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> // getFavoriteProductsFromLocal

    suspend operator fun invoke(item: FavoriteProductEntity) // insertFavoriteItemToDb
}
