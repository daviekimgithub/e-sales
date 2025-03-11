package com.josephnganga.eshop.domain.usecase.cart // ktlint-disable package-name

import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import com.josephnganga.eshop.domain.repository.LocalRepository
import javax.inject.Inject

class UpdateCartUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UpdateCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.updateUserCart(userCartEntity)
    }
}
