package com.example.projeto_quiz.tela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projeto_quiz.databinding.ActivityMainBinding
import com.example.projeto_quiz.QuizGeografia.GeografiaActivity
import com.example.projeto_quiz.QuizIngles.InglesActivity
import com.example.projeto_quiz.QuizMatematica.MatematicaActivity
import com.example.projeto_quiz.quizPortugues.Portugues_Activity


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*val fragmentManager = supportFragmentManager.beginTransaction()*/
        //val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_conteudo)
        binding.btnLP.setOnClickListener {
             intent = Intent(this, Portugues_Activity::class.java);
            startActivity(intent)
        }

        binding.btnMatematica.setOnClickListener {
            intent = Intent(this, MatematicaActivity::class.java);
            startActivity(intent)
        }

        binding.btnIngles.setOnClickListener {
            intent = Intent(this, InglesActivity::class.java);
            startActivity(intent)
        }
        binding.btnGeografia.setOnClickListener {
            intent = Intent(this, GeografiaActivity::class.java);
            startActivity(intent)
        }
    }
}



