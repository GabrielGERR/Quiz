package com.example.projeto_quiz.QuizGeografia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.R
import com.example.projeto_quiz.databinding.ActivityGeografiaBinding
import com.example.projeto_quiz.tela.MainActivity

class GeografiaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityGeografiaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.IBRetornar.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnGeo.setOnClickListener {
            intent = Intent(this, QuizGeografia1::class.java)
            startActivity(intent)
        }
        binding.btnGeo2.setOnClickListener {
            intent = Intent(this, QuizGeografia2::class.java)
            startActivity(intent)
        }
        binding.btnGeo3.setOnClickListener {
            intent = Intent(this, QuizGeografia3::class.java)
            startActivity(intent)
        }
    }

}