package com.josephnganga.eshop.ui.uiData

data class DetailProductUiData(
    val productId: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: List<String>,
    val rating: String,
)