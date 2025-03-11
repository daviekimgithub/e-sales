package com.josephnganga.eshop.di.mappers

import com.josephnganga.eshop.domain.entity.cart.UserCartEntity
import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import com.josephnganga.eshop.domain.entity.product.FavoriteProductEntity
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.entity.user.UserInformationEntity
import com.josephnganga.eshop.domain.mapper.ProductBaseMapper
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import com.josephnganga.eshop.ui.mapper.CartEntityToFavoriteEntityMapper
import com.josephnganga.eshop.ui.mapper.CartEntityToUiMapper
import com.josephnganga.eshop.ui.mapper.CartUiToEntityMapper
import com.josephnganga.eshop.ui.mapper.DetailProductEntityToUiMapper
import com.josephnganga.eshop.ui.mapper.FavoriteEntityToUiMapper
import com.josephnganga.eshop.ui.mapper.FavoriteUiToEntityMapper
import com.josephnganga.eshop.ui.mapper.ProductEntityToUiMapper
import com.josephnganga.eshop.ui.mapper.UserInfoEntityToUiDataMapper
import com.josephnganga.eshop.ui.mapper.UserInfoUiDataToEntityMapper
import com.josephnganga.eshop.ui.uiData.DetailProductUiData
import com.josephnganga.eshop.ui.uiData.FavoriteUiData
import com.josephnganga.eshop.ui.uiData.ProductUiData
import com.josephnganga.eshop.ui.uiData.UserCartUiData
import com.josephnganga.eshop.ui.uiData.UserInformationUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeProductUiMapper(productUiDataMapper: ProductEntityToUiMapper): ProductListMapper<ProductEntity, ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductUiMapper(productUiDataMapper: DetailProductEntityToUiMapper): ProductBaseMapper<DetailProductEntity, DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiMapper(cartUiDataMapper: CartEntityToUiMapper): ProductListMapper<UserCartEntity, UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartUiMapper(singleCartUiDataMapper: CartUiToEntityMapper): ProductBaseMapper<UserCartUiData, UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoEntityToUiDataMapper(userInformationUiDataMapper: UserInfoEntityToUiDataMapper): ProductBaseMapper<UserInformationEntity, UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToEntityMapper(userInformationEntityMapperToUi: UserInfoUiDataToEntityMapper): ProductBaseMapper<UserInformationUiData, UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteItemUiMapper(favoriteEntityToUiMapper: FavoriteEntityToUiMapper): ProductListMapper<FavoriteProductEntity, FavoriteUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleFavoriteItemUiMapper(favoriteUiToEntityMapper: FavoriteUiToEntityMapper): ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartToFavoriteEntityMapper(cartEntityToFavoriteEntityMapper: CartEntityToFavoriteEntityMapper): ProductBaseMapper<UserCartEntity, FavoriteProductEntity>
}
