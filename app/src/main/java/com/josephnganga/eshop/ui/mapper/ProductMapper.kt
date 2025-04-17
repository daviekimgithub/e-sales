package com.josephnganga.eshop.ui.mapper

import android.util.Log
import com.josephnganga.eshop.ui.uiData.ProductUiData
import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import javax.inject.Inject

class ProductEntityToUiMapper @Inject constructor() :
    ProductListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
        Log.e("some output", input.toString())
        return input.map {
            ProductUiData(
                id = it.id,
                title = it.title,
                description = it.description,
                price = (it.price.toDouble() * 10).toInt().toDouble(),
                imageUrl = it.imageUrl,
                rating = it.rating,
            )
        }
    }
}
