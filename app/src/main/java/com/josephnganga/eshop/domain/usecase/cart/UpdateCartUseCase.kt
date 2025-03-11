package com.josephnganga.eshop.domain.usecase.cart // ktlint-disable package-name

import com.josephnganga.eshop.domain.entity.cart.UserCartEntity

interface UpdateCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
