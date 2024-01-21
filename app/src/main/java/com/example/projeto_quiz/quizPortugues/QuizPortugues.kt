package com.example.projeto_quiz.quizPortugues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.QuizMatematica.MatematicaActivity
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding

class QuizPortugues : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
        val pergunta1 = Pergunta("1) Qual é a função da vírgula na frase \"O menino, que estava brincando, ficou feliz\"?",
            listOf(
                "Separar sujeito e predicado",
                "Indicar uma ação",
                "Isolar uma oração subordinada",
                "Conectar duas orações principais"
            ),"Isolar uma oração subordinada")
        val pergunta2 = Pergunta("2) Em \"O gato saltou o muro\", qual é a função sintática da palavra \"muro\"?",
            listOf(
                "Sujeito",
                "Objeto direto",
                "Objeto indireto",
                "Adjunto adverbial"
            ), "Objeto direto")
        val pergunta3 = Pergunta("3) Qual é a forma correta do plural de \"país\"?",
            listOf(
                "Paízes",
                "Pais",
                "Paises",
                "Países"
            ), "Países")
        val pergunta4 = Pergunta("4) Na frase \"Eu irei à festa, mesmo que chova\", qual é a conjunção destacada?",
            listOf(
                "Condicional",
                "Conclusiva",
                "Aditiva",
                "Concessiva"
            ), "Concessiva")
        val pergunta5 = Pergunta("5) O que são verbos transitivos diretos?",
            listOf(
                "Verbos que exigem um complemento",
                "Verbos que não exigem complemento",
                "Verbos que indicam uma ação",
                "Verbos que se flexionam"
            ), "Verbos que exigem um complemento")
        val pergunta6 = Pergunta("6) Qual é a função da conjunção \"mas\" na frase \"Gostaria de sair, mas estou ocupado\"?",
            listOf(
                "Adição",
                "Oposição",
                "Conclusão",
                "Condição"
            ), "Oposição")
        val pergunta7 = Pergunta("7) Em \"O carro é vermelho\", qual é a classe gramatical da palavra \"vermelho\"?",
            listOf(
                "Substantivo",
                "Adjetivo",
                "Advérbio",
                "Verbo"
            ), "Adjetivo")
        val pergunta8 = Pergunta("8) Qual é o plural de \"lápis\"?",
            listOf(
                "Lápis",
                "Lápisões",
                "Lápices",
                "Lápisses"
            ), "Lápices")
        val pergunta9 = Pergunta("9) O que são pronomes indefinidos?",
            listOf(
                "Pronomes que se referem a algo específico",
                "Pronomes que se referem a uma pessoa específica",
                "Pronomes que não se referem a algo ou alguém de forma precisa",
                "Pronomes que indicam posse"
            ), "Pronomes que não se referem a algo ou alguém de forma precisa")
        val pergunta10 = Pergunta("10) Qual é o antônimo de \"alegre\"?",
            listOf(
                "Triste",
                "Feliz",
                "Contente",
                "Radiante"
            ), "Triste")
        quizManager.obterPerguntas(pergunta1,pergunta2,pergunta3,pergunta4,pergunta5,pergunta6,pergunta7,pergunta8,pergunta9,pergunta10)
        quizManager.exibirPerguntaAtual()
    }
}

