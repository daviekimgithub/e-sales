package com.josephnganga.eshop.domain.usecase.category

import com.josephnganga.eshop.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}
