package com.josephnganga.eshop.ui.screens.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josephnganga.eshop.common.NetworkResponseState
import com.josephnganga.eshop.common.ScreenState
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import com.josephnganga.eshop.domain.usecase.category.CategoryUseCase
import com.josephnganga.eshop.domain.usecase.product.GetAllProductsUseCase
import com.josephnganga.eshop.domain.usecase.product.SearchProductUseCase
import com.josephnganga.eshop.ui.uiData.ProductUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val categoryUseCase: CategoryUseCase,
    private val searchProductUseCase: SearchProductUseCase,
    private val mapper: ProductListMapper<ProductEntity, ProductUiData>,
) :
    ViewModel() {
    private val _products = MutableLiveData<ScreenState<List<ProductUiData>>>()
    val products: LiveData<ScreenState<List<ProductUiData>>> get() = _products

    private val _categories = MutableLiveData<ScreenState<List<String>>>()
    val categories: LiveData<ScreenState<List<String>>> get() = _categories

    init {
        getAllCategory()
        getAllProducts()
    }

    private fun getAllProducts() {
        getAllProductsUseCase().onEach {
            when (it) {
                is NetworkResponseState.Error -> {
                    _products.postValue(ScreenState.Error(it.exception.message!!))
                    Log.e("data", it.exception.toString())
                    Log.e("data", it.exception.message.toString())
                }
                is NetworkResponseState.Loading -> _products.postValue(ScreenState.Loading)
                is NetworkResponseState.Success -> {
                    _products.postValue(ScreenState.Success(mapper.map(it.result)))
                    Log.e("data", it.result.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchProduct(query: String) {
        viewModelScope.launch {
            searchProductUseCase(query).onEach {
                when (it) {
                    is NetworkResponseState.Error -> _products.postValue(ScreenState.Error(it.exception.message!!))
                    is NetworkResponseState.Loading -> _products.postValue(ScreenState.Loading)
                    is NetworkResponseState.Success -> _products.postValue(ScreenState.Success(mapper.map(it.result)))
                }
            }.launchIn(viewModelScope)
        }
    }

    private fun getAllCategory() {
        categoryUseCase().onEach {
            when (it) {
                is NetworkResponseState.Error -> _categories.postValue(ScreenState.Error(it.exception.message!!))
                is NetworkResponseState.Loading -> _categories.postValue(ScreenState.Loading)
                is NetworkResponseState.Success -> _categories.postValue(ScreenState.Success(it.result))
            }
        }.launchIn(viewModelScope)
    }

    fun getProductsByCategory(categoryName: String) {
        getAllProductsUseCase(categoryName).onEach {
            when (it) {
                is NetworkResponseState.Error -> _products.postValue(ScreenState.Error(it.exception.message!!))
                is NetworkResponseState.Loading -> _products.postValue(ScreenState.Loading)
                is NetworkResponseState.Success -> _products.postValue(ScreenState.Success(mapper.map(it.result)))
            }
        }.launchIn(viewModelScope)
    }
}
