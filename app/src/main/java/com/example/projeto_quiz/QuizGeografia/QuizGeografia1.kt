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

class QuizGeografia1 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_geografiabr)
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
        val pergunta1 = Pergunta("1) Qual é a capital do estado do Amazonas?",
            listOf(
                "Manaus",
                "Belém",
                "Porto Alegre",
                "Recife"
            ), "Manaus")

        val pergunta2 = Pergunta("2) Quantos estados compõem a Região Norte do Brasil?",
            listOf(
                "4",
                "5",
                "6",
                "7"
            ), "7")

        val pergunta3 = Pergunta("3) Qual é o estado mais populoso do Brasil?",
            listOf(
                "São Paulo",
                "Rio de Janeiro",
                "Minas Gerais",
                "Bahia"
            ), "São Paulo")

        val pergunta4 = Pergunta("4) Em que estado brasileiro está localizado o Pantanal?",
            listOf(
                "Mato Grosso",
                "Mato Grosso do Sul",
                "Goiás",
                "Pará"
            ), "Mato Grosso do Sul")

        val pergunta5 = Pergunta("5) Qual é o estado conhecido como \"Terra do Sol Nascente\"?",
            listOf(
                "Bahia",
                "Alagoas",
                "Paraíba",
                "Espírito Santo"
            ), "Espírito Santo")

        val pergunta6 = Pergunta("6) A cidade de Natal é a capital de qual estado brasileiro?",
            listOf(
                "Rio Grande do Norte",
                "Ceará",
                "Paraíba",
                "Pernambuco"
            ), "Rio Grande do Norte")

        val pergunta7 = Pergunta("7) Quais estados brasileiros fazem parte da Região Centro-Oeste?",
            listOf(
                "Goiás, Mato Grosso, Mato Grosso do Sul e Distrito Federal",
                "Minas Gerais, São Paulo, Rio de Janeiro e Espírito Santo",
                "Pará, Amazonas, Roraima e Amapá",
                "Pernambuco, Paraíba, Rio Grande do Norte e Ceará"
            ), "Goiás, Mato Grosso, Mato Grosso do Sul e Distrito Federal")

        val pergunta8 = Pergunta("8) Qual é o único estado brasileiro que não faz divisa com nenhum outro país ou estado brasileiro?",
            listOf(
                "Maranhão",
                "Alagoas",
                "Piauí",
                "Espírito Santo"
            ), "Espírito Santo")

        val pergunta9 = Pergunta("9) Qual é o estado brasileiro conhecido como \"Terra dos Cajus\"?",
            listOf(
                "Ceará",
                "Rio Grande do Norte",
                "Paraíba",
                "Alagoas"
            ), "Rio Grande do Norte")

        val pergunta10 = Pergunta("10) A cidade de Florianópolis é a capital de qual estado brasileiro?",
            listOf(
                "Santa Catarina",
                "Rio Grande do Sul",
                "Paraná",
                "São Paulo"
            ), "Santa Catarina")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9, pergunta10
        )
        quizManager.exibirPerguntaAtual()
    }
}