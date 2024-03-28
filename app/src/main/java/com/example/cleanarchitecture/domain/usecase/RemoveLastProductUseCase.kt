package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.ProductRepository

class RemoveLastProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(){
        productRepository.removeLastProduct()
    }
}