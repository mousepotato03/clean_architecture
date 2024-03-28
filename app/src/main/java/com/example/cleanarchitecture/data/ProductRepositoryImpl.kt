package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.domain.ProductRepository
import kotlinx.coroutines.flow.Flow

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