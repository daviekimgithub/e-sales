package com.josephnganga.eshop.domain.repository

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {

    fun getProductsListFromApi(): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<DetailProductEntity>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<List<ProductEntity>>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
