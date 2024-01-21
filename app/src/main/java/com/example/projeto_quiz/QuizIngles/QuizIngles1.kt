package com.example.projeto_quiz.QuizIngles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizIngles1 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quiz_ingles)
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
                Log.d("QuizIngles", "Resposta incorreta")
            }
        }


    }
    private fun inicializarQuizManager(){
        quizManager = QuizManager(this, binding)
        val pergunta1 = Pergunta("1) What is the plural of 'child'?",
            listOf(
                "childs",
                "childes",
                "children",
                "child's"
            ), "children")

        val pergunta2 = Pergunta("2) Choose the correct form of the verb: 'She _______ to the store every day.'",
            listOf(
                "go",
                "goes",
                "going",
                " goed"
            ), "goes")

        val pergunta3 = Pergunta("3) What is the past participle of the verb 'eat'?",
            listOf(
                "eated",
                "aten",
                "ate",
                "eaten"
            ), "eaten")

        val pergunta4 = Pergunta("4) Identify the correct sentence:",
            listOf(
                "He don't like pizza.",
                "He doesn't like pizza.",
                "He not like pizza.",
                "He not liking pizza."
            ), "He doesn't like pizza.")

        val pergunta5 = Pergunta("5) Translate the word 'book' to French.",
            listOf(
                "livre",
                "maison",
                "table",
                "eau"
            ), "livre")

        val pergunta6 = Pergunta("6) In which sentence is 'going' a gerund?",
            listOf(
                "I am going to the store.",
                "I go to the store.",
                "I will go to the store.",
                "I will be going to the store."
            ), "I am going to the store.")

        val pergunta7 = Pergunta("7) Use the correct possessive pronoun: 'This is ____ book.'",
            listOf(
                "his",
                "her",
                "its",
                "our"
            ), "its")

        val pergunta8 = Pergunta("8) What is the comparative form of the adjective 'good'?",
            listOf(
                "gooder",
                "more good",
                "better",
                "best"
            ), "better")

        val pergunta9 = Pergunta("9) Form a question with the words: 'you / like / ice cream?'",
            listOf(
                "You like ice cream?",
                "Like you ice cream?",
                "Ice cream you like?",
                "Like ice cream you?"
            ), "You like ice cream?")

        val pergunta10 = Pergunta("10) What is the correct order of the words in a basic English sentence?",
            listOf(
                "Subject - Verb - Object",
                "Verb - Object - Subject",
                "Object - Subject - Verb",
                "Subject - Object - Verb"
            ), "Subject - Verb - Object")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9, pergunta10
        )
        quizManager.exibirPerguntaAtual()

    }
}