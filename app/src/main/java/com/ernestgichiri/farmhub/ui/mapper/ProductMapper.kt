package com.ernestgichiri.farmhub.ui.mapper

import com.ernestgichiri.farmhub.ui.uiData.ProductUiData
import com.ernestgichiri.farmhub.domain.entity.product.ProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductListMapper
import javax.inject.Inject

class ProductEntityToUiMapper @Inject constructor() :
    ProductListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
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
