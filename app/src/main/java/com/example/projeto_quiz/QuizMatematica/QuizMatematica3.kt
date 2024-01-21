package com.example.projeto_quiz.QuizMatematica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizMatematica3 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quizmatematica_3)
        if (savedInstanceState == null) {
            inicializarQuizManager()
        }

        binding.btnReninciar.setOnClickListener {
            quizManager.reiniciarQuiz()

            quizManager.exibirPerguntaAtual()
        }

        binding.btnSair.setOnClickListener {
            val intent = Intent(this, MatematicaActivity::class.java)
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
                Log.d("quizMatematica", "Resposta incorreta")
            }
        }

    }
    private fun inicializarQuizManager(){
        quizManager = QuizManager(this, binding)
        val pergunta1 = Pergunta("1) Resolva a equação logarítmica: (2^x = 16).",
            listOf(
                "x = 2",
                "x = 3",
                "x = 4",
                "x = 5"
            ), "x = 4")

        val pergunta2 = Pergunta("2) Se (f(x) = 3x^2 - 2x + 1), qual é o valor de (f(2))?",
            listOf(
                "5",
                "7",
                "9",
                "11"
            ), "9")

        val pergunta3 = Pergunta("3) Calcule a derivada de (y = 4x^3 - 2x^2 + 5x - 1) em relação a (x).",
            listOf(
                "12x^2 - 4x + 5",
                "6x^2 - 4x + 5",
                "12x^2 - 4x + 1",
                "6x^2 - 4x + 1"
            ), "12x^2 - 4x + 5")

        val pergunta4 = Pergunta("4) Se (a : b = 3 : 4) e (b : c = 5 : 2), qual é a razão (a : c)?",
            listOf(
                "15 : 8",
                "9 : 2",
                "5 : 3",
                "6 : 7"
            ), "15 : 2")

        val pergunta5 = Pergunta("5) Qual é a solução da equação quadrática (x^2 - 5x + 6 = 0)?",
            listOf(
                "x = 2 e x = 3",
                "x = 1 e x = 4",
                "x = 2 e x = 4",
                "x = 1 e x = 5"
            ), "x = 2 e x = 3")

        val pergunta6 = Pergunta("6) Se (A = {1, 2, 3}) e (B = {3, 4, 5}), qual é a interseção (A cap B)?",
            listOf(
                "{1, 2}",
                "{3}",
                "{4, 5}",
                "{1, 2, 3, 4, 5}"
            ), "{3}")

        val pergunta7 = Pergunta("7) Qual é a área de um triângulo com base 6 unidades e altura 8 unidades?",
            listOf(
                "24 unidades quadradas",
                "30 unidades quadradas",
                "36 unidades quadradas",
                "48 unidades quadradas"
            ), "24 unidades quadradas")

        val pergunta8 = Pergunta("8) Se (n!) representa o fatorial de (n), qual é o valor de (4!)?",
            listOf(
                "12",
                "24",
                "48",
                "96"
            ), "24")

        val pergunta9 = Pergunta("9) Qual é o valor absoluto de (-7)?",
            listOf(
                "7",
                "(-7)",
                "0",
                "(sqrt{49})"
            ), "7")

        val pergunta10 = Pergunta("10) Se (P(A) = 0.4) e (P(B) = 0.6), qual é a probabilidade de (A) e (B) ocorrerem juntos se eles são eventos independentes?",
            listOf(
                "0.24",
                "0.36",
                "0.4",
                "0.6"
            ), "0.24")


        quizManager.obterPerguntas(pergunta1,pergunta2,pergunta3,pergunta4,pergunta5,pergunta6,pergunta7,pergunta8,pergunta9,pergunta10)
        quizManager.exibirPerguntaAtual()
    }
}