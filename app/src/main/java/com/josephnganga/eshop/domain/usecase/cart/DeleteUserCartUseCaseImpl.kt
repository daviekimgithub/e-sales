package com.josephnganga.eshop.domain.usecase.cart

import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import com.josephnganga.eshop.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteUserCartUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteUserCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.deleteUserCart(userCartEntity)
    }
}
