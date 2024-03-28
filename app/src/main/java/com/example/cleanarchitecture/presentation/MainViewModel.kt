package com.example.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.DependenciesProvider
import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.domain.ProductRepository
import com.example.cleanarchitecture.domain.usecase.AddProductUseCase
import com.example.cleanarchitecture.domain.usecase.GetProductsUseCase
import com.example.cleanarchitecture.domain.usecase.LoadProductAllUseCase
import com.example.cleanarchitecture.domain.usecase.RemoveLastProductUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val getProductsUseCase: GetProductsUseCase = DependenciesProvider.getProductsUseCase,
    private val loadProductAllUseCase: LoadProductAllUseCase = DependenciesProvider.loadProductsUseCase,
    private val addProductUseCase: AddProductUseCase = DependenciesProvider.addProductAllUseCase,
    private val removeLastProductUseCase: RemoveLastProductUseCase = DependenciesProvider.removeLastProductUseCase
) : ViewModel() {
    val products = getProductsUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun loadProductAll(){
        viewModelScope.launch { loadProductAllUseCase() }
    }

    fun addProduct(product: Product){
        viewModelScope.launch { addProductUseCase(product) }
    }

    fun removeLastProduct(){
        viewModelScope.launch { removeLastProductUseCase() }
    }
}