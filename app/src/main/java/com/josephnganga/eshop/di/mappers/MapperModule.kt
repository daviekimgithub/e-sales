package com.josephnganga.eshop.di.mappers

import com.josephnganga.eshop.data.dto.Category
import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.mapper.ProductBaseMapper
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import com.josephnganga.eshop.data.dto.Product
import com.josephnganga.eshop.data.mapper.CategoryEntityMapper
import com.josephnganga.eshop.data.mapper.ProductEntityMapper
import com.josephnganga.eshop.data.mapper.SingleProductEntityMapper
import com.mustafaunlu.ecommerce_compose.domain.entity.category.CategoryEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAllProductsEntityMapper(productEntityMapper: ProductEntityMapper): ProductListMapper<Product, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindAllCategoriesEntityMapper(productEntityMapper: CategoryEntityMapper): ProductListMapper<Category, String>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper): ProductBaseMapper<Product, DetailProductEntity>
}
