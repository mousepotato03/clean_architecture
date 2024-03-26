package com.example.cleanarchitecture

import com.example.cleanarchitecture.data.ProductRepositoryImpl
import com.example.cleanarchitecture.domain.ProductRepository

object DependenciesProvider {
    val productRepository: ProductRepository = ProductRepositoryImpl()
}