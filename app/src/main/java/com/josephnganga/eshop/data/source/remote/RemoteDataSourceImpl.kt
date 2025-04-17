package com.josephnganga.eshop.data.source.remote

import android.util.Log
import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.data.api.ApiService
import com.josephnganga.eshop.data.dto.Category
import com.josephnganga.eshop.data.dto.Product
import com.josephnganga.eshop.data.dto.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : RemoteDataSource {
    override fun getProductsListFromApi(): Flow<NetworkResponseState<Products>> {
        return flow {
            emit(NetworkResponseState.Loading)
            val response = apiService.getProductsListFromApi()
            Log.e("response", response.toString())
            emit(NetworkResponseState.Success(response))
        }.catch { e ->
            Log.e("error", e.toString())
            emit(NetworkResponseState.Error(e as Exception))
        }
    }

    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>> {
        return flow {
            emit(NetworkResponseState.Loading)
            val response = apiService.getSingleProductByIdFromApi(productId)
            emit(NetworkResponseState.Success(response))
        }.catch { e ->
            emit(NetworkResponseState.Error(e as Exception))
        }
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>> {
        return flow {
            emit(NetworkResponseState.Loading)
            val response = apiService.getProductsListBySearchFromApi(query)
            emit(NetworkResponseState.Success(response))
        }.catch { e ->
            emit(NetworkResponseState.Error(e as Exception))
        }
    }

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<Category>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            val response = apiService.getAllCategoriesListFromApi()
            emit(NetworkResponseState.Success(response))
        }.catch { e ->
            emit(NetworkResponseState.Error(e as Exception))
        }
    }

    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>> {
        return flow {
            emit(NetworkResponseState.Loading)
            val response = apiService.getProductsListByCategoryNameFromApi(categoryName)
            emit(NetworkResponseState.Success(response))
        }.catch { e ->
            emit(NetworkResponseState.Error(e as Exception))
        }
    }
}