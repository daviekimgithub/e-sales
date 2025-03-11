package com.josephnganga.eshop.domain.usecase.cart

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> // getCartsByUserIdFromLocal

    suspend operator fun invoke(userCartEntity: UserCartEntity) // insertCartToDb
}
