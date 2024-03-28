package com.example.cleanarchitecture.domain

import com.example.cleanarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}