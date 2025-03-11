package com.josephnganga.eshop.domain.usecase.product

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow

interface SearchProductUseCase {
    operator fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
