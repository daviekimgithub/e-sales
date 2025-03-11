package com.josephnganga.eshop.data.source.remote

import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.data.dto.Category
import com.josephnganga.eshop.data.dto.Product
import com.josephnganga.eshop.data.dto.Products
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getProductsListFromApi(): Flow<NetworkResponseState<Products>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<Category>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>
}
