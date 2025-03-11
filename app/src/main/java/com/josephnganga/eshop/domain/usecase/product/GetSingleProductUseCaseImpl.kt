package com.josephnganga.eshop.domain.usecase.product

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import com.josephnganga.eshop.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetSingleProductUseCase {
    override fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>> =
        repository.getSingleProductByIdFromApi(id)
}
