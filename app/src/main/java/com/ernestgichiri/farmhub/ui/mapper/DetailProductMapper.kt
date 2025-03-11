package com.ernestgichiri.farmhub.ui.mapper // ktlint-disable filename

import com.ernestgichiri.farmhub.domain.entity.product.DetailProductEntity
import com.ernestgichiri.farmhub.domain.mapper.ProductBaseMapper
import com.ernestgichiri.farmhub.ui.uiData.DetailProductUiData
import javax.inject.Inject

class DetailProductEntityToUiMapper @Inject constructor() :
    ProductBaseMapper<DetailProductEntity, DetailProductUiData> {
    override fun map(input: DetailProductEntity): DetailProductUiData {
        return DetailProductUiData(
            productId = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toDouble(),
            imageUrl = input.imageUrl,
            rating = input.rating,
        )
    }
}
