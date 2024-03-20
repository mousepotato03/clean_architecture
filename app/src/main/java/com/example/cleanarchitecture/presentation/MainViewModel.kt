package com.example.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.domain.PRODUCT_SAMPLE
import com.example.cleanarchitecture.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _products = MutableStateFlow(emptyList<Product>())
    val products = _products.asStateFlow()

    fun loadProductAll(){
        _products.update { PRODUCT_SAMPLE }
    }

    fun addProduct(product: Product){
        _products.getAndUpdate { it + product }
    }

    fun removeProduct(){
        _products.getAndUpdate { it.dropLast(1) }
    }
}