package com.example.unidad2prac3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.unidad2prac3.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth

class Registrar : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar Firebase Auth de forma directa
        auth = FirebaseAuth.getInstance()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Se corrigieron los IDs para alinearse con activity_registrar.xml
        binding.btnConfirmRegister.setOnClickListener {
            val correo = binding.etNewEmail.text.toString().trim()
            val pass = binding.etNewPassword.text.toString().trim()

            if (correo.isNotEmpty() && pass.isNotEmpty()) {
                registrarUsuario(correo, pass)
            } else {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón Cancelar
        binding.btnRegister.setOnClickListener {
            finish()
        }
    }

    private fun registrarUsuario(correo: String, password: String) {
        auth.createUserWithEmailAndPassword(correo, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext,
                        "Registro exitoso",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish() // Regresa al Login tras registrar
                } else {
                    Toast.makeText(
                        baseContext,
                        "Error en el registro: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
}