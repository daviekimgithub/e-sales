package com.josephnganga.eshop.domain.usecase.user.sign_up

import com.josephnganga.eshop.domain.entity.user.UserInformationEntity

interface FirebaseUserSignUpUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
