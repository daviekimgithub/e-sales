package com.josephnganga.eshop.ui.screens.auth.viewModels

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josephnganga.eshop.common.Constants.PREF_FIREBASE_USERID_KEY
import com.josephnganga.eshop.common.ScreenState
import com.josephnganga.eshop.domain.entity.user.FirebaseSignInUserEntity
import com.josephnganga.eshop.domain.entity.user.UserInformationEntity
import com.josephnganga.eshop.domain.mapper.ProductBaseMapper
import com.josephnganga.eshop.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import com.josephnganga.eshop.ui.uiData.UserInformationUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigInViewModel @Inject constructor(
    private val firebaseUserSingInUseCase: FirebaseUserSingInUseCase,
    private val firebaseUserInfoToUiData: ProductBaseMapper<UserInformationEntity, UserInformationUiData>,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {

    private val _firebaseLoginState = MutableLiveData<ScreenState<UserInformationUiData>>()
    val firebaseLoginState: LiveData<ScreenState<UserInformationUiData>> get() = _firebaseLoginState

    fun loginWithFirebase(user: FirebaseSignInUserEntity) {
        viewModelScope.launch {
            _firebaseLoginState.postValue(ScreenState.Loading)
            firebaseUserSingInUseCase.invoke(
                user,
                onSuccess = {
                    _firebaseLoginState.postValue(
                        ScreenState.Success(
                            firebaseUserInfoToUiData.map(
                                it,
                            ),
                        ),
                    )
                    saveUserIdToSharedPref(it.id)
                },
            ) {
                _firebaseLoginState.postValue(ScreenState.Error(it))
            }
        }
    }

    private fun saveUserIdToSharedPref(id: String) {
        sharedPreferences.edit()
            .putString(PREF_FIREBASE_USERID_KEY, id)
            .apply()
    }
}
