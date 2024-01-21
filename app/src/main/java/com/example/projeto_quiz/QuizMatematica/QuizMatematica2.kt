package com.example.projeto_quiz.QuizMatematica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizMatematica2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quizmatematica_1)
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
        val pergunta1 = Pergunta("1) Qual é a soma de (frac{3}{5} + frac{2}{3})?",
            listOf(
                "(frac{1}{15})",
                "(frac{11}{15})",
                "(frac{13}{15})",
                "(frac{5}{8})"
            ), "(frac{11}{15})")

        val pergunta2 = Pergunta("2) Se (a) é o dobro de (frac{1}{3}), qual é o valor de (a)?",
            listOf(
                "(frac{2}{3})",
                "(frac{4}{3})",
                "(frac{2}{9})",
                "(frac{5}{6})"
            ), "(frac{2}{3})")

        val pergunta3 = Pergunta("3) Multiplique (frac{4}{7} times frac{3}{5}).",
            listOf(
                "(frac{2}{7})",
                "(frac{6}{35})",
                "(frac{12}{35})",
                "(frac{7}{20})"
            ), "(frac{12}{35})")

        val pergunta4 = Pergunta("4) Qual é a diferença entre (frac{5}{8}) e (frac{3}{4})?",
            listOf(
                "(frac{1}{8})",
                "(frac{1}{4})",
                "(frac{3}{8})",
                "(frac{5}{16})"
            ), "(frac{1}{8})")

        val pergunta5 = Pergunta("5) Se (x) é 20% de (frac{1}{2}), qual é o valor de (x)?",
            listOf(
                "(frac{1}{5})",
                "(frac{1}{10})",
                "(frac{1}{20})",
                "(frac{1}{40})"
            ), "(frac{1}{10})")

        val pergunta6 = Pergunta("6) Divida (frac{2}{3}) por (frac{4}{5}).",
            listOf(
                "(frac{5}{6})",
                "(frac{4}{5})",
                "(frac{5}{8})",
                "(frac{8}{15})"
            ), "(frac{5}{6})")

        val pergunta7 = Pergunta("7) Se (x + frac{3}{4} = 2), qual é o valor de (x)?",
            listOf(
                "(frac{1}{4})",
                "(frac{5}{4})",
                "(frac{7}{4})",
                "(frac{9}{4})"
            ), "(frac{5}{4})")

        val pergunta8 = Pergunta("8) Qual é a média de (frac{1}{3}), (frac{2}{5}) e (frac{4}{9})?",
            listOf(
                "(frac{7}{15})",
                "(frac{5}{9})",
                "(frac{11}{15})",
                "(frac{3}{5})"
            ), "(frac{23}{45})")

        val pergunta9 = Pergunta("9) Se (y) é 25% de (frac{2}{3}), qual é o valor de (y)?",
            listOf(
                "(frac{1}{6})",
                "(frac{1}{9})",
                "(frac{1}{8})",
                "(frac{1}{12})"
            ), "(frac{1}{6})")

        val pergunta10 = Pergunta("10) Simplifique (frac{9}{12}) para a forma mais reduzida.",
            listOf(
                "(frac{3}{4})",
                "(frac{2}{3})",
                "(frac{1}{2})",
                "(frac{3}{2})"
            ), "(frac{3}{4})")


        quizManager.obterPerguntas(pergunta1,pergunta2,pergunta3,pergunta4,pergunta5,pergunta6,pergunta7,pergunta8,pergunta9,pergunta10)
        quizManager.exibirPerguntaAtual()
    }
}