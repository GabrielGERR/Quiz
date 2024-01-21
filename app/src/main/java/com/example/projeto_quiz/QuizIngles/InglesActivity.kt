package com.example.projeto_quiz.QuizIngles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityInglesBinding
import com.example.projeto_quiz.tela.MainActivity

class InglesActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityInglesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.IBRetornar.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnIngles1.setOnClickListener {
            intent = Intent(this, QuizIngles1::class.java)
            startActivity(intent)
        }
        binding.btnIngles2.setOnClickListener {
            intent = Intent(this, QuizIngles2::class.java)
            startActivity(intent)
        }
        binding.btnIngles3.setOnClickListener {
            intent = Intent(this, QuizIngles3::class.java)
            startActivity(intent)
        }
    }
}
