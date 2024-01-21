package com.example.projeto_quiz.QuizMatematica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityMatematicaBinding
import com.example.projeto_quiz.databinding.ActivityPortuguesBinding
import com.example.projeto_quiz.tela.MainActivity

class MatematicaActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMatematicaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.IBRetornar.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnMat1.setOnClickListener {
            intent = Intent(this, QuizMatematica::class.java)
            startActivity(intent)
        }
        binding.btnmat2.setOnClickListener {
            intent = Intent(this, QuizMatematica2::class.java)
            startActivity(intent)
        }
        binding.btnmat3.setOnClickListener {
            intent = Intent(this, QuizMatematica3::class.java)
            startActivity(intent)
        }
    }
}