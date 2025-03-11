package com.josephnganga.eshop.domain.usecase.cart

import com.josephnganga.eshop.domain.entity.cart.UserCartEntity

interface DeleteUserCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
