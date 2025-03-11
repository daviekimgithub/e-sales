package com.josephnganga.eshop.domain.usecase.user.read_user

import com.josephnganga.eshop.domain.entity.user.UserInformationEntity

interface ReadFirebaseUserInfosUseCase {
    operator fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )
}
