package com.example.projeto_quiz.Classes

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.projeto_quiz.tela.MainActivity

import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding
import com.example.projeto_quiz.tela.tela_conclusao

class QuizManager(private val context: Context, private val binding: ActivityQuizPortuguesBinding?) {
     var indicePerguntaAtual: Int = 0
     var respostasCorretas: Int = 0
    lateinit var perguntas: List<Pergunta>
    private val respostasCorretasList: MutableList<String> = mutableListOf()

    fun obterPerguntas(vararg perguntas: Pergunta) {
        this.perguntas = perguntas.toList()
    }
    fun reiniciarQuiz() {
        indicePerguntaAtual = 0
        respostasCorretas = 0
        respostasCorretasList.clear()
        // Adicione aqui qualquer outra lógica de reinicialização necessária
    }
    @SuppressLint("WrongConstant")
    fun destacarRespostas(context: Context) {
        val perguntaAtual = perguntas[indicePerguntaAtual]
        val radioButtonId = binding?.RadioGroupPergunta?.checkedRadioButtonId
        val respostaSelecionada = radioButtonId?.let {
            binding?.RadioGroupPergunta?.findViewById<RadioButton>(it)?.text.toString()
        }

        // Resetar as cores das respostas para a cor padrão (preta)
        for (i in 0 until binding?.RadioGroupPergunta?.childCount!!) {
            val radioButton = binding?.RadioGroupPergunta?.getChildAt(i) as RadioButton
            radioButton.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        }

        // Desabilitar RadioButtons após o usuário responder
        for (i in 0 until binding?.RadioGroupPergunta?.childCount!!) {
            val radioButton = binding?.RadioGroupPergunta?.getChildAt(i) as RadioButton
            radioButton.isEnabled = false
        }

        // Destacar respostas corretas e erradas
        for (i in 0 until binding?.RadioGroupPergunta?.childCount!!) {
            val radioButton = binding?.RadioGroupPergunta?.getChildAt(i) as RadioButton
            val opcao = radioButton.text.toString()
            if (opcao == perguntaAtual.respostaCorreta) {
                // Destacar alternativa correta de verde
                radioButton.setTextColor(
                    if (opcao == respostaSelecionada) {
                        // Se a resposta selecionada for correta, destaque-a também
                        respostasCorretasList.add(opcao) // Adiciona a resposta correta à lista
                        ContextCompat.getColor(context, android.R.color.holo_green_dark)
                    } else {
                        ContextCompat.getColor(context, android.R.color.holo_green_dark)
                    }
                )
            } else {
                // Destacar alternativa errada de vermelho
                radioButton.setTextColor(
                    if (opcao == respostaSelecionada) {
                        // Se a resposta selecionada for errada, destaque-a de vermelho
                        ContextCompat.getColor(context, android.R.color.holo_red_dark)
                    } else {
                        ContextCompat.getColor(context, android.R.color.holo_red_dark)
                    }
                )
            }
        }

        // Adicionar atraso de 3 segundos antes de avançar para a próxima pergunta
        Handler(Looper.getMainLooper()).postDelayed({
            // Resetar as cores das respostas para a cor padrão (preta)
            for (i in 0 until binding?.RadioGroupPergunta?.childCount!!) {
                val radioButton = binding?.RadioGroupPergunta?.getChildAt(i) as RadioButton
                radioButton.setTextColor(ContextCompat.getColor(context, android.R.color.black))
            }

            // Habilitar RadioButtons após o tempo decorrido
            for (i in 0 until binding?.RadioGroupPergunta?.childCount!!) {
                val radioButton = binding?.RadioGroupPergunta?.getChildAt(i) as RadioButton
                radioButton.isEnabled = true
            }

            proximaPergunta()
        }, 2000)
    }


    fun exibirTelaConclusao() {
        val intent = Intent(context, tela_conclusao::class.java)
        intent.putExtra("respostasCorretas", respostasCorretas)
        intent.putStringArrayListExtra("respostasCorretasList", ArrayList(respostasCorretasList))
        intent.putExtra("tituloQuiz", "Português")
        startActivity(context, intent, null)
    }


    fun proximaPergunta() {
        binding?.RadioGroupPergunta?.clearCheck()

        if (indicePerguntaAtual < perguntas.size - 1) {
            indicePerguntaAtual++
            exibirPerguntaAtual()
        } else {
            exibirResultados()
        }
    }
    fun respostaCorreta(): Boolean {
        val perguntaAtual = perguntas[indicePerguntaAtual]
        val radioButtonId = binding?.RadioGroupPergunta?.checkedRadioButtonId
        val respostaSelecionada = radioButtonId?.let {
            binding?.RadioGroupPergunta?.findViewById<RadioButton>(it)?.text.toString()
        }

        return respostaSelecionada == perguntaAtual.respostaCorreta
    }
    @SuppressLint("WrongConstant")
    fun exibirResultados() {
        val mensagem = "Você acertou $respostasCorretas de ${perguntas.size} perguntas."
        val toast = Toast.makeText(context, mensagem, Toast.LENGTH_SHORT)
        toast.duration = 5000 // 2000 milissegundos (2 segundos)
        toast.show()

    }



    fun validarResposta(): Boolean {
        return binding?.RadioGroupPergunta?.checkedRadioButtonId != -1
    }

     fun exibirPerguntaAtual() {
        val perguntaAtual = perguntas[indicePerguntaAtual]
        binding?.textPergunta?.text = perguntaAtual.texto
        binding?.RBPergunta1?.text = perguntaAtual.opcoes[0]
        binding?.RBPergunta2?.text = perguntaAtual.opcoes[1]
        binding?.RBPergunta3?.text = perguntaAtual.opcoes[2]
        binding?.RBPergunta4?.text = perguntaAtual.opcoes[3]
    }

     fun exibirToast(mensagem: String) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
    }
}
