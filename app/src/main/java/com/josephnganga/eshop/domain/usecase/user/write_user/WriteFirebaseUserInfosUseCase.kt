package com.josephnganga.eshop.domain.usecase.user.write_user

import com.josephnganga.eshop.domain.entity.user.UserInformationEntity

interface WriteFirebaseUserInfosUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
