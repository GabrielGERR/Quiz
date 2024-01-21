package com.example.projeto_quiz.Classes

data class Pergunta(
    val texto: String,
    val opcoes: List<String>,
    val respostaCorreta: String
)
