package com.josephnganga.eshop.domain.usecase.product

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetAllProductsUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>> = repository.getProductsListFromApi()

    override fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListByCategoryNameFromApi(categoryName)
    }
}
