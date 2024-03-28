package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.ProductRepository

class LoadProductAllUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(){
        productRepository.loadProductAll()
    }
}