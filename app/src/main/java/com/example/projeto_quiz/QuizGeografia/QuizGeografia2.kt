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

class QuizGeografia2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quiz_geografia)
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
        val pergunta1 = Pergunta("1) Qual é o maior oceano do mundo?",
            listOf(
                "Oceano Atlântico",
                "Oceano Índico",
                "Oceano Ártico",
                "Oceano Pacífico"
            ), "Oceano Pacífico")

        val pergunta2 = Pergunta("2) Qual é o ponto mais alto da Terra?",
            listOf(
                "Monte Everest",
                "Monte Kilimanjaro",
                "Monte Aconcágua",
                "Monte McKinley"
            ), "Monte Everest")

        val pergunta3 = Pergunta("3) Quais são os cinco grandes lagos da América do Norte?",
            listOf(
                "Lago Superior, Lago Michigan, Lago Erie, Lago Huron, Lago Ontario",
                "Lago Baikal, Lago Titicaca, Lago Vostok, Lago Malawi, Lago Tanganica",
                "Lago Ness, Lago Geneva, Lago Como, Lago Maggiore, Lago Garda",
                "Lago Victoria, Lago Chad, Lago Turkana, Lago Albert, Lago Edward"
            ), "Lago Superior, Lago Michigan, Lago Erie, Lago Huron, Lago Ontario")

        val pergunta4 = Pergunta("4) Quais são os países que formam a Península Ibérica?",
            listOf(
                "Espanha e França",
                "Portugal e Espanha",
                "Itália e Grécia",
                "Alemanha e Áustria"
            ), "Portugal e Espanha")

        val pergunta5 = Pergunta("5) Qual é o maior deserto quente do mundo?",
            listOf(
                "Deserto do Atacama",
                "Deserto do Saara",
                "Deserto da Arábia",
                "Deserto de Gobi"
            ), "Deserto do Saara")

        val pergunta6 = Pergunta("6) Em que continente está localizado o Polo Norte?",
            listOf(
                "Ásia",
                "Europa",
                "América do Norte",
                "Antártida"
            ), "Antártida")

        val pergunta7 = Pergunta("7) Qual é a capital da Índia?",
            listOf(
                "Nova Deli",
                "Mumbai",
                "Calcutá",
                "Bangalore"
            ), "Nova Deli")

        val pergunta8 = Pergunta("8) Qual é o maior rio do mundo em volume de água?",
            listOf(
                "Rio Amazonas",
                "Rio Nilo",
                "Rio Yangtzé",
                "Rio Mississipi"
            ), "Rio Amazonas")

        val pergunta9 = Pergunta("9) Em que país está localizado o Monte Fuji?",
            listOf(
                "China",
                "Japão",
                "Coreia do Sul",
                "Indonésia"
            ), "Japão")

        val pergunta10 = Pergunta("10) Qual é a capital da Austrália?",
            listOf(
                "Melbourne",
                "Sydney",
                "Brisbane",
                "Camberra"
            ), "Camberra")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9, pergunta10
        )
        quizManager.exibirPerguntaAtual()
    }
}