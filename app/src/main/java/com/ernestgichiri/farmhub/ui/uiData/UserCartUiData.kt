package com.ernestgichiri.farmhub.ui.uiData

data class UserCartUiData(
    val userId: String,
    val productId: Int,
    val price: Double,
    val quantity: Int,
    val title: String,
    val imageUrl: String,
)