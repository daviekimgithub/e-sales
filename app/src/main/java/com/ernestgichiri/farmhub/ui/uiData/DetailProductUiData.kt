package com.ernestgichiri.farmhub.ui.uiData

data class DetailProductUiData(
    val productId: Int,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl: List<String>,
    val rating: String,
)