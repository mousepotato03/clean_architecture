package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {
    operator fun invoke() = productRepository.products
}