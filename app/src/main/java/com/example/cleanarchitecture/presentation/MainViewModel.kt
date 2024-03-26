package com.example.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.DependenciesProvider
import com.example.cleanarchitecture.domain.PRODUCT_SAMPLE
import com.example.cleanarchitecture.domain.Product
import com.example.cleanarchitecture.domain.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val productRepository: ProductRepository = DependenciesProvider.productRepository
) : ViewModel() {
    val products = productRepository.products.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun loadProductAll(){
        viewModelScope.launch {
            productRepository.loadProductAll()
        }
    }

    fun addProduct(product: Product){
        viewModelScope.launch {
            productRepository.addProduct(product)
        }
    }

    fun removeLastProduct(){
        viewModelScope.launch {
            productRepository.removeLastProduct()
        }
    }
}