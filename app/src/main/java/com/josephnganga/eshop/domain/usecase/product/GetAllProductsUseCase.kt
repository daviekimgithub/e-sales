package com.josephnganga.eshop.domain.usecase.product

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetAllProductsUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>>

    operator fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
