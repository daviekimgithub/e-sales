package com.josephnganga.eshop.data.mapper

import com.josephnganga.eshop.domain.entity.product.DetailProductEntity
import com.josephnganga.eshop.domain.mapper.ProductBaseMapper
import com.josephnganga.eshop.data.dto.Product
import javax.inject.Inject

class SingleProductEntityMapper @Inject constructor() :
    ProductBaseMapper<Product, DetailProductEntity> {
    override fun map(input: Product): DetailProductEntity {
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toString(),
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}
