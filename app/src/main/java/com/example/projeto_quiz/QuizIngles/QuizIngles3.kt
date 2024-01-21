package com.example.projeto_quiz.QuizIngles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizIngles3 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quiz_ingles3)
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
        val pergunta1 = Pergunta("1) What is the opposite of the word 'happy'?",
            listOf(
                "sad",
                "angry",
                "excited",
                "joyful"
            ), "sad")

        val pergunta2 = Pergunta("2) Translate the word 'house' to Spanish.",
            listOf(
                "casa",
                "libro",
                "agua",
                "comida"
            ), "casa")

        val pergunta3 = Pergunta("3) Form a question with the words: 'you / like / ice cream?'",
            listOf(
                "You like ice cream?",
                "Like you ice cream?",
                "Ice cream you like?",
                "Like ice cream you?"
            ), "You like ice cream?")

        val pergunta4 = Pergunta("4) Choose the correct preposition: 'The cat is _____ the table.'",
            listOf(
                "on",
                "in",
                "under",
                "above"
            ), "on")

        val pergunta5 = Pergunta("5) Use the correct possessive pronoun: 'This is ____ book.'",
            listOf(
                "his",
                "her",
                "its",
                "our"
            ), "its")

        val pergunta6 = Pergunta("6) What is the plural of the word 'child'?",
            listOf(
                "childs",
                "childes",
                "children",
                "child's"
            ), "children")

        val pergunta7 = Pergunta("7) Choose the correct article: '______ apple a day keeps the doctor away.'",
            listOf(
                "An",
                "A",
                "The",
                "Some"
            ), "A")

        val pergunta8 = Pergunta("8) What is the color of the sun?",
            listOf(
                "Yellow",
                "Red",
                "Blue",
                "Green"
            ), "Yellow")

        val pergunta9 = Pergunta("9) Complete the sentence: 'I ______ to the park every Sunday.'",
            listOf(
                "go",
                "goes",
                "going",
                " goed"
            ), "go")

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