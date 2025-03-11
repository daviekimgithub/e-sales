package com.josephnganga.eshop.data.mapper

import com.josephnganga.eshop.data.dto.Category
import com.josephnganga.eshop.domain.mapper.ProductListMapper
import javax.inject.Inject

class CategoryEntityMapper @Inject constructor() :
ProductListMapper<Category, String> {
    override fun map(input: List<Category>): List<String> {
        return input.map {
            it.name
        }
    }
}
