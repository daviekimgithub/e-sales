package com.josephnganga.eshop.domain.usecase.product

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface GetSingleProductUseCase {
    operator fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>>
}
