package com.josephnganga.eshop.ui.uiData

data class ProductUiData(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: List<String>,
    val rating: Double,
)