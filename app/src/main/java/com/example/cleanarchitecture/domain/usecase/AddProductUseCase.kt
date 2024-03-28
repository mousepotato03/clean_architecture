package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.ProductRepository
import com.example.cleanarchitecture.domain.model.Product

class AddProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(product: Product){
        productRepository.addProduct(product)
    }
}