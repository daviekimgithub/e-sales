package com.ernestgichiri.farmhub.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "slug")
    val slug: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String,
)
