package com.example.cleanarchitecture.domain

import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}