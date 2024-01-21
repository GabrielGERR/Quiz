package com.example.projeto_quiz.quizPortugues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projeto_quiz.Classes.QuizManager
import com.example.projeto_quiz.Classes.Pergunta
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding


class QuizPortugues3 : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizPortuguesBinding.inflate(layoutInflater)
    }
    private lateinit var quizManager: QuizManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.imageView5.setImageResource(R.drawable.img_quizlinguaportuguesa)
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

    private fun inicializarQuizManager() {
        quizManager = QuizManager(this, binding)

        val pergunta1 = Pergunta("1) Na oração 'A prosa se desdobra em múltiplas nuances', identifique a figura de linguagem presente.",
            listOf(
                "Metonímia",
                "Pleonasmo",
                "Anacronia",
                "Catacrese"
            ), "Metonímia")

        val pergunta2 = Pergunta("2) O que caracteriza a elipse na linguagem escrita?",
            listOf(
                "Repetição de uma mesma ideia",
                "Inversão da ordem natural das palavras",
                "Omissão de um termo inferível pelo contexto",
                "Uso exagerado de palavras"
            ), "Omissão de um termo inferível pelo contexto")

        val pergunta3 = Pergunta("3) Identifique a figura de linguagem na frase: 'A morte, cruel e impiedosa, espreita silenciosamente.'",
            listOf(
                "Antítese",
                "Metáfora",
                "Silepse",
                "Eufemismo"
            ), "Silepse")

        val pergunta4 = Pergunta("4) O que são pronomes de tratamento e qual é a sua função?",
            listOf(
                "Pronomes que indicam posse",
                "Pronomes que substituem substantivos",
                "Pronomes que estabelecem relação de respeito ou deferência",
                "Pronomes indefinidos"
            ), "Pronomes que estabelecem relação de respeito ou deferência")

        val pergunta5 = Pergunta("5) Explique a diferença entre uma antítese e um paradoxo.",
            listOf("Ambos são sinônimos",
                "Antítese aproxima termos opostos, paradoxo é contradição aparente",
                "Antítese é figura de linguagem, paradoxo é recurso estilístico",
                "Paradoxo é figura de linguagem, antítese é contradição lógica"),
            "Antítese aproxima termos opostos, paradoxo é contradição aparente")

        val pergunta6 = Pergunta("6) Qual é a função da conjunção 'entretanto' na frase: 'Estudou muito; " +
                "entretanto, não obteve êxito.'?",
            listOf(
                "Adição",
                "Conclusão",
                "Oposição",
                "Condição"),"Oposição")

        val pergunta7 = Pergunta("7) Na frase 'A chuva insistente, como lágrimas tristes, molhava o solo', qual é a figura de linguagem utilizada?",
            listOf(
                "Metonímia",
                "Personificação",
                "Eufemismo",
                "Sinestesia"), "Personificação")

        val pergunta8 = Pergunta("8) Qual é a diferença entre um texto dissertativo e um texto narrativo?",
            listOf(
                "Texto dissertativo é objetivo, texto narrativo é subjetivo",
                "Texto narrativo conta uma história, texto dissertativo defende uma tese",
                "Texto narrativo sempre tem diálogos, texto dissertativo não",
                "Ambos são sinônimos"
            ), "Texto narrativo conta uma história, texto dissertativo defende uma tese")

        val pergunta9 = Pergunta("9) Na frase 'A tempestade rugia com fúria', que figura de linguagem é utilizada?",
            listOf(
                "Metáfora",
                "Hipérbole",
                "Metonímia",
                "Onomatopeia"
            ),
            "Personificação")

        val pergunta10 = Pergunta("10) O que caracteriza um pleonasmo e dê um exemplo.",
            listOf(
                "Redundância desnecessária como 'subir para cima'",
                "Expressão oposta à realidade",
                "Linguagem poética com palavras ambíguas",
                "Repetição de uma mesma ideia"),
            "Redundância desnecessária, como 'subir para cima'")

        quizManager.obterPerguntas(
            pergunta1, pergunta2, pergunta3, pergunta4, pergunta5,
            pergunta6, pergunta7, pergunta8, pergunta9 ,pergunta10
        )
        quizManager.exibirPerguntaAtual()
    }
}