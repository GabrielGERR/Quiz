package com.example.projeto_quiz.QuizIngles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizIngles2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageView5.setImageResource(R.drawable.img_quiz_ingles2)
        if (savedInstanceState == null) {
            inicializarQuizManager()
        }

        binding.btnReninciar.setOnClickListener {
            quizManager.reiniciarQuiz()

            quizManager.exibirPerguntaAtual()
        }

        binding.btnSair.setOnClickListener {
            val intent = Intent(this, InglesActivity::class.java)
            startActivity(intent)
        }

        binding.FABAvancar.setOnClickListener {
            if (quizManager.validarResposta()) {
                if (quizManager.respostaCorreta()) {
                    quizManager.respostasCorretas++ // Incrementando respostasCorretas se a resposta for correta
                }
                quizManager.destacarRespostas(this)
                if (quizManager.indicePerguntaAtual == quizManager.perguntas.size - 1) {
                    quizManager.exibirTelaConclusao()
                }
            } else {
                Log.d("QuizPortugues", "Resposta incorreta")
            }
        }

    }
    private fun inicializarQuizManager(){
        quizManager = QuizManager(this, binding)
        val pergunta1 = Pergunta("1) What is the capital of Brazil?",
            listOf(
                "Buenos Aires",
                "Lima",
                "Santiago",
                "Brasília"
            ), "Brasília")

        val pergunta2 = Pergunta("2) In which country is the Eiffel Tower located?",
            listOf(
                "Italy",
                "France",
                "Germany",
                "Spain"
            ), "France")

        val pergunta3 = Pergunta("3) What is the official language of Japan?",
            listOf(
                "Mandarin",
                "Japanese",
                "Korean",
                "Thai"
            ), "Japanese")

        val pergunta4 = Pergunta("4) Which continent is Egypt located in?",
            listOf(
                "Africa",
                "Asia",
                "Europe",
                "South America"
            ), "Africa")

        val pergunta5 = Pergunta("5) What is the currency of Mexico?",
            listOf(
                "Peso",
                "Dollar",
                "Euro",
                "Yen"
            ), "Peso")

        val pergunta6 = Pergunta("6) In which country is Mount Everest located?",
            listOf(
                "India",
                "Nepal",
                "China",
                "Bhutan"
            ), "Nepal")

        val pergunta7 = Pergunta("7) What is the official language of Russia?",
            listOf(
                "Russian",
                "Ukrainian",
                "Georgian",
                "Armenian"
            ), "Russian")

        val pergunta8 = Pergunta("8) In which country is the Great Barrier Reef located?",
            listOf(
                "Australia",
                "Indonesia",
                "Philippines",
                "Maldives"
            ), "Australia")

        val pergunta9 = Pergunta("9) What is the capital of South Africa?",
            listOf(
                "Cape Town",
                "Johannesburg",
                "Pretoria",
                "Durban"
            ), "Pretoria")

        val pergunta10 = Pergunta("10) Which country is known as the 'Land of the Rising Sun'?",
            listOf(
                "China",
                "Japan",
                "South Korea",
                "Vietnam"
            ), "Japan")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9, pergunta10
        )
        quizManager.exibirPerguntaAtual()

    }
}