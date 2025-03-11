package com.josephnganga.eshop.di.usecase

import com.josephnganga.eshop.domain.usecase.cart.CartUseCase
import com.josephnganga.eshop.domain.usecase.cart.CartUseCaseImpl
import com.josephnganga.eshop.domain.usecase.cart.DeleteUserCartUseCase
import com.josephnganga.eshop.domain.usecase.cart.DeleteUserCartUseCaseImpl
import com.josephnganga.eshop.domain.usecase.cart.UpdateCartUseCase
import com.josephnganga.eshop.domain.usecase.cart.UpdateCartUseCaseImpl
import com.josephnganga.eshop.domain.usecase.cart.badge.UserCartBadgeUseCase
import com.josephnganga.eshop.domain.usecase.cart.badge.UserCartBadgeUseCaseImpl
import com.josephnganga.eshop.domain.usecase.category.CategoryUseCase
import com.josephnganga.eshop.domain.usecase.category.CategoryUseCaseImpl
import com.josephnganga.eshop.domain.usecase.favorite.DeleteFavoriteUseCase
import com.josephnganga.eshop.domain.usecase.favorite.DeleteFavoriteUseCaseImpl
import com.josephnganga.eshop.domain.usecase.favorite.FavoriteUseCase
import com.josephnganga.eshop.domain.usecase.favorite.FavoriteUseCaseImpl
import com.josephnganga.eshop.domain.usecase.product.GetAllProductsUseCase
import com.josephnganga.eshop.domain.usecase.product.GetAllProductsUseCaseImpl
import com.josephnganga.eshop.domain.usecase.product.GetSingleProductUseCase
import com.josephnganga.eshop.domain.usecase.product.GetSingleProductUseCaseImpl
import com.josephnganga.eshop.domain.usecase.product.SearchProductUseCase
import com.josephnganga.eshop.domain.usecase.product.SearchProductUseCaseImpl
import com.josephnganga.eshop.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCase
import com.josephnganga.eshop.domain.usecase.user.forget_pw.ForgotPwFirebaseUserUseCaseImpl
import com.josephnganga.eshop.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import com.josephnganga.eshop.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCaseImpl
import com.josephnganga.eshop.domain.usecase.user.sign_in.FirebaseUserSingInUseCase
import com.josephnganga.eshop.domain.usecase.user.sign_in.FirebaseUserSingInUseCaseImpl
import com.josephnganga.eshop.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import com.josephnganga.eshop.domain.usecase.user.sign_up.FirebaseUserSignUpUseCaseImpl
import com.josephnganga.eshop.domain.usecase.user.write_user.WriteFirebaseUserInfosCaseImpl
import com.josephnganga.eshop.domain.usecase.user.write_user.WriteFirebaseUserInfosUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl,
    ): GetAllProductsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetSingleProductUseCase(
        getSingleProductUseCaseImpl: GetSingleProductUseCaseImpl,
    ): GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllCategoryUseCase(
        getAllCategoryUseCaseImpl: CategoryUseCaseImpl,
    ): CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCartUseCase(
        cartUseCaseImpl: CartUseCaseImpl,
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        deleteUserCartUseCaseImpl: DeleteUserCartUseCaseImpl,
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSearchUseCase(
        searchUseCaseImpl: SearchProductUseCaseImpl,
    ): SearchProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateCartUseCase(
        updateCartUseCaseImpl: UpdateCartUseCaseImpl,
    ): UpdateCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        favoriteUseCaseImpl: FavoriteUseCaseImpl,
    ): FavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        deleteFavoriteUseCaseImpl: DeleteFavoriteUseCaseImpl,
    ): DeleteFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignUpUseCase(
        firebaseSignUpUseCaseImpl: FirebaseUserSignUpUseCaseImpl,
    ): FirebaseUserSignUpUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseSignInUseCase(
        firebaseSignInUseCaseImpl: FirebaseUserSingInUseCaseImpl,
    ): FirebaseUserSingInUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseForgetPwUseCase(
        firebaseForgetPwUseCaseImpl: ForgotPwFirebaseUserUseCaseImpl,
    ): ForgotPwFirebaseUserUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseWriteUserUseCase(
        firebaseWriteUserUseCaseImpl: WriteFirebaseUserInfosCaseImpl,
    ): WriteFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseReadUserUseCase(
        firebaseReadUserCaseImpl: ReadFirebaseUserInfosUseCaseImpl,
    ): ReadFirebaseUserInfosUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        userCartBadgeUseCaseImpl: UserCartBadgeUseCaseImpl,
    ): UserCartBadgeUseCase
}
