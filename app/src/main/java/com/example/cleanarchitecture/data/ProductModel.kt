package com.example.cleanarchitecture.data

import com.example.cleanarchitecture.domain.Product
import java.util.Date

data class ProductModel(
    val id: String,
    val name: String,
    val price: Int,
    val description: String,
    val createdAt: Date,
    val updatedAt: Date
)

fun ProductModel.toDomainModel():Product = Product(
    id = this.id,
    name = this.name,
    price = this.price
)

fun Product.toDataModel():ProductModel = ProductModel(
    id = this.id,
    name = this.name,
    price = this.price,
    description = "",
    createdAt = Date(),
    updatedAt = Date()
)

val PRODUCT_SAMPLE = listOf(
    ProductModel("p1","prod-1",1,"desc-1",Date(),Date()),
    ProductModel("p2","prod-2",2,"desc-2",Date(),Date()),
    ProductModel("p3","prod-3",3,"desc-3",Date(),Date()),
    ProductModel("p4","prod-4",4,"desc-4",Date(),Date()),
    ProductModel("p5","prod-5",5,"desc-5",Date(),Date())
)