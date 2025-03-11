package com.josephnganga.eshop.domain.usecase.cart.badge

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCartBadgeUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UserCartBadgeUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<Int>> {
        return repository.getBadgeCountFromDb(userId)
    }
}
