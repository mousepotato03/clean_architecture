package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.PRODUCT_SAMPLE
import com.example.cleanarchitecture.domain.Product
import com.example.cleanarchitecture.domain.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

class ProductRepositoryImpl : ProductRepository {
    private val _products = MutableStateFlow(emptyList<Product>())
    override val products: Flow<List<Product>> = _products.asStateFlow()

    override suspend fun loadProductAll(){
        _products.update { PRODUCT_SAMPLE }
    }

    override suspend fun addProduct(product: Product){
        _products.getAndUpdate { it + product }
    }

    override suspend fun removeLastProduct(){
        _products.getAndUpdate { it.dropLast(1) }
    }
}