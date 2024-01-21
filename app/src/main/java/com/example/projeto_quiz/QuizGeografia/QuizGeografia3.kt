package com.example.projeto_quiz.QuizGeografia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.QuizIngles.InglesActivity
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizGeografia3 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_geografia_quiz)
        if (savedInstanceState == null) {
            inicializarQuizManager()
        }

        binding.btnReninciar.setOnClickListener {
            quizManager.reiniciarQuiz()

            quizManager.exibirPerguntaAtual()
        }

        binding.btnSair.setOnClickListener {
            val intent = Intent(this, GeografiaActivity::class.java)
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
        val pergunta1 = Pergunta("1) Qual foi a capital do Império Romano?",
            listOf(
                "Atenas",
                "Constantinopla",
                "Roma",
                "Alexandria"
            ), "Roma")

        val pergunta2 = Pergunta("2) Qual é a antiga cidade egípcia conhecida por suas pirâmides?",
            listOf(
                "Luxor",
                "Alexandria",
                "Giza",
                "Tebas"
            ), "Giza")

        val pergunta3 = Pergunta("3) A Babilônia foi uma antiga cidade localizada em qual região?",
            listOf(
                "Mesopotâmia",
                "Egito",
                "Grécia",
                "Pérsia"
            ), "Mesopotâmia")

        val pergunta4 = Pergunta("4) A cidade de Troia, famosa pela Guerra de Troia, estava localizada em qual país?",
            listOf(
                "Grécia",
                "Itália",
                "Turquia",
                "Egito"
            ), "Turquia")

        val pergunta5 = Pergunta("5) O Coliseu era uma arena de gladiadores em qual cidade antiga?",
            listOf(
                "Atenas",
                "Roma",
                "Esparta",
                "Cartago"
            ), "Roma")

        val pergunta6 = Pergunta("6) Qual foi a capital do Império Persa?",
            listOf(
                "Babilônia",
                "Persépolis",
                "Susa",
                "Ecbátana"
            ), "Persépolis")

        val pergunta7 = Pergunta("7) Onde fica localizada a antiga cidade de Machu Picchu?",
            listOf(
                "México",
                "Peru",
                "Guatemala",
                "Bolívia"
            ), "Peru")

        val pergunta8 = Pergunta("8) A Grande Muralha da China foi construída para se proteger contra invasões de qual povo nômade?",
            listOf(
                "Mongóis",
                "Persas",
                "Árabes",
                "Hunos"
            ), "Mongóis")

        val pergunta9 = Pergunta("9) Quem foi o grande líder militar cartaginense que comandou elefantes durante a Segunda Guerra Púnica?",
            listOf(
                "Alexandre, o Grande",
                "Aníbal",
                "Ciro, o Grande",
                "Júlio César"
            ), "Aníbal")

        val pergunta10 = Pergunta("10) O que o Rio Nilo representava para a antiga civilização egípcia?",
            listOf(
                "Uma barreira natural contra invasões",
                "A principal rota comercial",
                "Fonte de água potável",
                "Fonte de fertilidade para a agricultura"
            ), "Fonte de fertilidade para a agricultura")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9, pergunta10
        )
        quizManager.exibirPerguntaAtual()

    }
}