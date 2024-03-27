package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update

class InMemoryProductDataSource: ProductDataSource {
    private val _products = MutableStateFlow(emptyList<ProductModel>())
    override val products: Flow<List<Product>> = _products.map{productList->
        productList.map { it.toDomainModel() }
    }

    override suspend fun loadProductAll(){
        _products.update { PRODUCT_SAMPLE }
    }

    override suspend fun addProduct(product: Product){
        _products.getAndUpdate { it + product.toDataModel() }
    }

    override suspend fun removeLastProduct(){
        _products.getAndUpdate { it.dropLast(1) }
    }
}