package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.Product
import com.example.cleanarchitecture.domain.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

class ProductRepositoryImpl(private val productDataSource: ProductDataSource) : ProductRepository {
    override val products: Flow<List<Product>> = productDataSource.products

    override suspend fun loadProductAll(){
        productDataSource.loadProductAll()
    }

    override suspend fun addProduct(product: Product){
        productDataSource.addProduct(product)
    }

    override suspend fun removeLastProduct(){
        productDataSource.removeLastProduct()
    }
}