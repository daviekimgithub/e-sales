package com.josephnganga.eshop.ui.uiData

data class FavoriteUiData(
    val userId: String,
    val productId: Int,
    val price: Double,
    val quantity: Int,
    val title: String,
    val imageUrl: String,
)