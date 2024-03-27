package com.example.cleanarchitecture

import com.example.cleanarchitecture.data.InMemoryProductDataSource
import com.example.cleanarchitecture.data.ProductDataSource
import com.example.cleanarchitecture.data.ProductRepositoryImpl
import com.example.cleanarchitecture.domain.ProductRepository

object DependenciesProvider {
    val productDataSource: ProductDataSource = InMemoryProductDataSource()
    val productRepository: ProductRepository = ProductRepositoryImpl(productDataSource)
}