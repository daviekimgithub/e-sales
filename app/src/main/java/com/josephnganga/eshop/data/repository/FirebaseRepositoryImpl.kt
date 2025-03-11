package com.josephnganga.eshop.data.repository

import com.josephnganga.eshop.domain.entity.user.FirebaseSignInUserEntity
import com.josephnganga.eshop.domain.entity.user.UserInformationEntity
import com.josephnganga.eshop.domain.repository.FirebaseRepository
import com.josephnganga.eshop.common.TokenManager
import com.josephnganga.eshop.data.source.remote.FirebaseDataSource
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource,
    private val tokenManager: TokenManager,
) : FirebaseRepository {
    override fun signUpWithFirebase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.signUpWithFirebase(user, onSuccess, onFailure)
    }

    override fun signInWithFirebase(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.signInWithFirebase(
            user,
            onSuccess = { userInformationEntity ->
                tokenManager.saveToken(userInformationEntity.token)
                onSuccess(userInformationEntity)
            },
            onFailure,
        )
    }

    override fun forgotPassword(email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        firebaseDataSource.forgotPassword(email, onSuccess, onFailure)
    }

    override fun writeNewUserToFirebaseDatabase(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.writeUserDataToFirebase(user, onSuccess, onFailure)
    }

    override fun readUserFromFirebaseDatabase(
        userMail: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseDataSource.readUserDataFromFirebase(userMail, onSuccess, onFailure)
    }
}
