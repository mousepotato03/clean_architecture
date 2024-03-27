package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.Flow

interface ProductDataSource {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}