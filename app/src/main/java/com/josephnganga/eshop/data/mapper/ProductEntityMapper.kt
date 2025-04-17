package com.josephnganga.eshop.data.mapper

import com.josephnganga.eshop.domain.entity.product.ProductEntity
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import com.josephnganga.eshop.data.dto.Product
import javax.inject.Inject

class ProductEntityMapper @Inject constructor() :
    ProductListMapper<Product, ProductEntity> {

    // Define a default image URL (you can put this in constants)
    private val defaultImageUrl = "https://example.com/default_product_image.jpg"

    override fun map(input: List<Product>): List<ProductEntity> {
        return input.map { product ->
            ProductEntity(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                imageUrl = buildImageList(product), // Extracted to separate function
                rating = product.rating.toDoubleOrNull() ?: 0.0
            )
        }
    }

    private fun buildImageList(product: Product): List<String> {
        return buildList {
            // Add thumbnail if it's not empty/null
            if (!product.thumbnail.isNullOrBlank()) {
                add(product.thumbnail)
            } else {
                add(defaultImageUrl) // Add default if thumbnail is missing
            }

            // Add all other images that are not empty/null
            addAll(product.images.filter { !it.isNullOrBlank() })

            // If we ended up with no images at all, add the default
            if (isEmpty()) {
                add(defaultImageUrl)
            }
        }
    }
}