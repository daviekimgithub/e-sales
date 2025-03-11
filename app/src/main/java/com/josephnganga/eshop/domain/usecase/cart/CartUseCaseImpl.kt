package com.josephnganga.eshop.domain.usecase.cart

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import com.josephnganga.eshop.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCaseImpl @Inject constructor(private val repository: LocalRepository) : CartUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> = repository.getCartsByUserIdFromDb(userId)
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.insertUserCartToDb(userCartEntity)
    }
}
