package com.example.tasksapp

import java.io.Serializable

class Product(
    val id: Int,
    val name: String): Serializable {

    override fun toString(): String {
        return "$id - $name"
    }
}