package com.example.unidad2prac3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unidad2prac3.databinding.ActivitySaludoBinding

class Saludo : AppCompatActivity() {

    private lateinit var binding: ActivitySaludoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mail: String = intent.extras?.getString("correoUsuario").orEmpty()
        binding.tvTitulo.text = "Hola $mail"
    }
}
