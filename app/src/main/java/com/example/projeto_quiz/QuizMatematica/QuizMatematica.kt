
package com.example.projeto_quiz.QuizMatematica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.QuizIngles.InglesActivity
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizMatematica : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quizmatematica_2)
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
        val pergunta1 = Pergunta("1) Quanto é 7 x 8?",
            listOf(
                "54",
                "56",
                "64",
                "72"
            ), "56")

        val pergunta2 = Pergunta("2) Resolva a expressão: (15 - 3 times 2)",
            listOf(
                "18",
                "24",
                "9",
                "15"
            ), "9")

        val pergunta3 = Pergunta("3) Se um quadrado tem um lado de comprimento 5 unidades, qual é a sua área?",
            listOf(
                "10 unidades quadradas",
                "15 unidades quadradas",
                "20 unidades quadradas",
                "25 unidades quadradas"
            ), "25 unidades quadradas")

        val pergunta4 = Pergunta("4) Qual é o resultado de (3^4)?",
            listOf(
                "12",
                "81",
                "64",
                "27"
            ), "81")

        val pergunta5 = Pergunta("5) Simplifique a expressão: (frac{4}{6} + frac{3}{2})",
            listOf(
                "(frac{2}{3})",
                "(frac{5}{2})",
                "(frac{7}{3})",
                "(frac{9}{6})"
            ), "(frac{5}{2})")

        val pergunta6 = Pergunta("6) Se (x + 8 = 15), qual é o valor de (x)?",
            listOf(
                "7",
                "10",
                "15",
                "23"
            ), "7")

        val pergunta7 = Pergunta("7) Calcule o valor de (sqrt{49}).",
            listOf(
                "5",
                "6",
                "7",
                "8"
            ), "7")

        val pergunta8 = Pergunta("8) Qual é o perímetro de um retângulo com comprimento 12 unidades e largura 8 unidades?",
            listOf(
                "24 unidades",
                "32 unidades",
                "40 unidades",
                "48 unidades"
            ), "40 unidades")

        val pergunta9 = Pergunta("9) Resolva a equação: (2x - 5 = 11).",
            listOf(
                "x = 3",
                "x = 8",
                "x = 6",
                "x = 9"
            ), "x = 8")

        val pergunta10 = Pergunta("10) Se um número aumentado em 20% é 120, qual é esse número?",
            listOf(
                "80",
                "90",
                "100",
                "110"
            ), "100")

        quizManager.obterPerguntas(pergunta1,pergunta2,pergunta3,pergunta4,pergunta5,pergunta6,pergunta7,pergunta8,pergunta9,pergunta10)
        quizManager.exibirPerguntaAtual()
    }
}