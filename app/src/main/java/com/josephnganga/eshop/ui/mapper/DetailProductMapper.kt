package com.josephnganga.eshop.ui.mapper // ktlint-disable filename

import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import com.josephnganga.eshop.domain.mapper.ProductBaseMapper
import com.josephnganga.eshop.ui.uiData.DetailProductUiData
import javax.inject.Inject

class DetailProductEntityToUiMapper @Inject constructor() :
    ProductBaseMapper<DetailProductEntity, DetailProductUiData> {
    override fun map(input: DetailProductEntity): DetailProductUiData {
        return DetailProductUiData(
            productId = input.id,
            title = input.title,
            description = input.description,
            price = (input.price.toDouble() * 10).toInt().toDouble(),
            imageUrl = input.imageUrl,
            rating = input.rating,
        )
    }
}
