package com.josephnganga.eshop.domain.usecase.user.read_user

import com.josephnganga.eshop.domain.entity.user.UserInformationEntity
import com.josephnganga.eshop.domain.repository.FirebaseRepository
import javax.inject.Inject

class ReadFirebaseUserInfosUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository
): ReadFirebaseUserInfosUseCase {
    override fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        repository.readUserFromFirebaseDatabase(userId, onSuccess, onFailure)
    }
}