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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cleanarchitecture.domain.PRODUCT_SAMPLE
import com.example.cleanarchitecture.domain.Product
import com.example.cleanarchitecture.ui.theme.CleanArchitectureTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Scaffold(
        content = {
                  Column(modifier = Modifier.padding(it)) {
                      ItemList(productList = PRODUCT_SAMPLE)
                  }
        },
        bottomBar = { ButtonBar()}
    )
}

@Composable
fun ItemList(productList: List<Product>){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(productList){
            Text(text = it.name)
        }
    }
}

@Composable
fun ButtonBar(){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Load")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Add")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Remove")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640 )
@Composable
fun MainScreenPreView(){
    CleanArchitectureTheme {
        MainScreen()
    }
}