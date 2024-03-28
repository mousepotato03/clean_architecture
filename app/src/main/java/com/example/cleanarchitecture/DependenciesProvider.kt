package com.example.cleanarchitecture

import com.example.cleanarchitecture.data.InMemoryProductDataSource
import com.example.cleanarchitecture.data.ProductDataSource
import com.example.cleanarchitecture.data.ProductRepositoryImpl
import com.example.cleanarchitecture.domain.ProductRepository
import com.example.cleanarchitecture.domain.usecase.AddProductUseCase
import com.example.cleanarchitecture.domain.usecase.GetProductsUseCase
import com.example.cleanarchitecture.domain.usecase.LoadProductAllUseCase
import com.example.cleanarchitecture.domain.usecase.RemoveLastProductUseCase

object DependenciesProvider {
    val productDataSource: ProductDataSource = InMemoryProductDataSource()
    val productRepository: ProductRepository = ProductRepositoryImpl(productDataSource)
    val getProductsUseCase: GetProductsUseCase = GetProductsUseCase(productRepository)
    val loadProductsUseCase:LoadProductAllUseCase = LoadProductAllUseCase(productRepository)
    val addProductAllUseCase:AddProductUseCase = AddProductUseCase(productRepository)
    val removeLastProductUseCase:RemoveLastProductUseCase = RemoveLastProductUseCase(productRepository)
}