package com.example.cleanarchitecture.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cleanarchitecture.domain.model.Product
import com.example.cleanarchitecture.ui.theme.CleanArchitectureTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val viewModel = viewModel<MainViewModel>()
    val products by viewModel.products.collectAsStateWithLifecycle()

    Scaffold(
        content = {
                  Column(modifier = Modifier.padding(it)) {
                      ItemList(products)
                  }
        },
        bottomBar = { ButtonBar(viewModel)}
    )
}

@Composable
fun ItemList(productList: List<Product>){
    if(productList.isEmpty()){ Text(text = "No Item") }
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(productList){
            Text(text = it.name)
        }
    }
}

@Composable
fun ButtonBar(viewModel: MainViewModel){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = { viewModel.loadProductAll() }) {
            Text(text = "Load")
        }
        Button(onClick = { viewModel.addProduct(product()) }) {
            Text(text = "Add")
        }
        Button(onClick = { viewModel.removeLastProduct() }) {
            Text(text = "Remove")
        }
    }
}

fun product() = Product(
        id = "p${Random.nextInt()}",
        name = "prod-${Random.nextInt()}",
        price = Random.nextInt()
    )

@Preview(showBackground = true, widthDp = 320, heightDp = 640 )
@Composable
fun MainScreenPreView(){
    CleanArchitectureTheme {
        MainScreen()
    }
}