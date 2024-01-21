package com.example.projeto_quiz.quizPortugues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizPortugues2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quiz_portugues2)
        if (savedInstanceState == null) {
            inicializarQuizManager()
        }

        binding.btnReninciar.setOnClickListener {
            quizManager.reiniciarQuiz()

            quizManager.exibirPerguntaAtual()
        }

        binding.btnSair.setOnClickListener {
            val intent = Intent(this, Portugues_Activity::class.java)
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

        val pergunta1 = Pergunta("1) Na frase \"O coelho pulou a cerca\", qual é o sujeito?",
            listOf("Coelho", "Pulou", "Cerca", "O"),
            "Coelho")
        val pergunta2 = Pergunta("2) O que são palavras homônimas?",
            listOf(
                "Palavras que têm significados opostos",
                "Palavras que têm a mesma grafia e som, mas significados diferentes",
                "Palavras que rimam entre si",
                "Palavras que são usadas apenas em poesia"
            ), "Palavras que têm a mesma grafia e som, mas significados diferentes")
        val pergunta3 = Pergunta("3) Qual é o plural de \"papel\"?",
            listOf(
                "Papéis",
                "Papeis",
                "Papéies",
                "Papelões"
            ), "Papéis")
        val pergunta4 = Pergunta("4) Na frase \"Os pássaros cantavam alegremente\", qual é o adjetivo?",
            listOf(
                "Pássaros",
                "Cantavam",
                "Alegremente",
                "Os"
            ), "Alegremente")
        val pergunta5 = Pergunta("5) O que são substantivos concretos?",
            listOf(
                "Substantivos que representam ideias abstratas",
                "Substantivos que representam coisas tangíveis",
                "Substantivos que não têm forma física",
                "Substantivos que expressam sentimentos"
            ), "Substantivos que representam coisas tangíveis")
        val pergunta6 = Pergunta("6) Na frase \"O menino estava cansado, mas feliz\", qual é a conjunção coordenativa?",
            listOf(
                "Estava",
                "Mas",
                "Feliz",
                "O"
            ), "Mas")
        val pergunta7 = Pergunta("7) O que são verbos intransitivos?",
            listOf(
                "Verbos que não exigem um complemento",
                "Verbos que sempre são acompanhados de preposição",
                "Verbos que indicam uma ação",
                "Verbos que têm múltiplos significados"
            ), "Verbos que não exigem um complemento")
        val pergunta8 = Pergunta("8) Qual é o sujeito da frase \"Choveu durante a noite\"?",
            listOf(
                "Choveu",
                "Durante a noite",
                "Noite",
                "O"
            ), "Choveu")
        val pergunta9 = Pergunta("9) Na palavra \"amizade\", qual é o radical?",
            listOf(
                "Ami",
                "Amiz",
                "Amizad",
                "Ade"
            ), "Amiz")
        val pergunta10 = Pergunta("10) O que são conjunções subordinativas?",
            listOf(
                "Conjunções que unem termos de mesma função sintática",
                "Conjunções que unem orações independentes",
                "Conjunções que indicam uma relação de subordinação entre orações",
                "Conjunções que conectam palavras de mesmo significado"
            ), "Conjunções que indicam uma relação de subordinação entre orações")
        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9 ,pergunta10
        )
        quizManager.exibirPerguntaAtual()
    }
}