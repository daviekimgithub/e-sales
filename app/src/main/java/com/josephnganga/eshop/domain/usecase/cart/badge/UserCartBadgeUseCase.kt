package com.josephnganga.eshop.domain.usecase.cart.badge

import com.josephnganga.eshop.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface UserCartBadgeUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<Int>>
}