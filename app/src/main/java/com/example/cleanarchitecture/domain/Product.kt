package com.example.cleanarchitecture.domain

data class Product(
    val id: String,
    val name: String,
    val price: Int
)

val PRODUCT_SAMPLE = listOf(
    Product("p1","prod-1",1),
    Product("p2","prod-2",2),
    Product("p3","prod-3",3),
    Product("p4","prod-4",4),
    Product("p5","prod-5",5)
)