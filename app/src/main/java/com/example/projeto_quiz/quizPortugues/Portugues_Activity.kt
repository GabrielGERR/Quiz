package com.example.projeto_quiz.quizPortugues


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.databinding.ActivityPortuguesBinding
import com.example.projeto_quiz.tela.MainActivity


class Portugues_Activity : AppCompatActivity() {
    private val binding by lazy {
        ActivityPortuguesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.IBRetornar.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnPortugues.setOnClickListener {
            intent = Intent(this, QuizPortugues::class.java);
            startActivity(intent)
        }
        binding.btnPortugues2.setOnClickListener {
            intent = Intent(this, QuizPortugues2::class.java);
            startActivity(intent)
        }
        binding.btnPortugues3.setOnClickListener {
            intent = Intent(this, QuizPortugues3::class.java);
            startActivity(intent)
        }
    }
}