package com.example.exercicioalunos

class Aluno(val nome: String, val morada: String, val email: String) {
    override fun toString(): String {
        return nome
    }

    fun dadosAluno(): String {
        return "Nome: $nome\nMorada: $morada\nEmail: $email"
    }
}