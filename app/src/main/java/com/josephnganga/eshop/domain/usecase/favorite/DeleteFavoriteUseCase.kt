package com.josephnganga.eshop.domain.usecase.favorite

import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity

interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}