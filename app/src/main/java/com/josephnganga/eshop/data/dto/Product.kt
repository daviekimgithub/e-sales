package com.josephnganga.eshop.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "category")
    val category: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "discount_percentage")
    val discountPercentage: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<String>,
    @Json(name = "price")
    val price: String,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "stock")
    val stock: Int,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String,
)
