package com.example.exercicioslistas

class Utilizador(val username: String, val password: String) {
    override fun toString(): String {
        return "username='$username'\npassword='$password'"
    }
}