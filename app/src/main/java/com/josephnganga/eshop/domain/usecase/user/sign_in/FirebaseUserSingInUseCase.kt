package com.josephnganga.eshop.domain.usecase.user.sign_in

import com.josephnganga.eshop.domain.entity.user.FirebaseSignInUserEntity
import com.josephnganga.eshop.domain.entity.user.UserInformationEntity

interface FirebaseUserSingInUseCase {
    operator fun invoke(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}