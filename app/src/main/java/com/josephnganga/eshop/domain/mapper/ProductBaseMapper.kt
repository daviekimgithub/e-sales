package com.josephnganga.eshop.domain.mapper

interface ProductBaseMapper<I, O> {
    fun map(input: I): O
}
