package com.example.projeto_quiz.tela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityQuizPortuguesBinding
import com.example.projeto_quiz.databinding.ActivityTelaConclusaoBinding

class tela_conclusao : AppCompatActivity() {
    private val binding by lazy {
        ActivityTelaConclusaoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val respostasCorretas = intent.getIntExtra("respostasCorretas", 0)

        binding.IBVoltar.setOnClickListener {
            val itent  = Intent(this, MainActivity::class.java)
            startActivity(itent)
        }



        binding.textRespostasCorretas.text = "$respostasCorretas"
        binding.textResultado.text = "Você acertou $respostasCorretas de 10 perguntas"


        if (respostasCorretas == 0){
            binding.imgEstrela.setImageResource(R.drawable.img_acertounada)
        } else if (respostasCorretas <= 5) {
            binding.imgEstrela.setImageResource(R.drawable.img_estrela_bronze)
        } else if (respostasCorretas <= 9) {
            binding.imgEstrela.setImageResource(R.drawable.img_estrela_prata)
        } else {
            binding.imgEstrela.setImageResource(R.drawable.img_estrela_ouro)
        }
    }
}