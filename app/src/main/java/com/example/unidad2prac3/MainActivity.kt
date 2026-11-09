package com.example.unidad2prac3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unidad2prac3.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inicializar Firebase Auth de forma directa
        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val intento = Intent(this, Saludo::class.java)
            intento.putExtra("correoUsuario", email)
            startActivity(intento)
        }

        binding.btnRegister.setOnClickListener {
            val intento = Intent(this, Registrar::class.java)
            startActivity(intento)
        }
    }
}
