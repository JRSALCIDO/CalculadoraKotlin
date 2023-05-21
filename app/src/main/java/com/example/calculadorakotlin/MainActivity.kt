package com.example.calculadorakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtUsuario = findViewById(R.id.txtUsuario)
        txtContraseña = findViewById(R.id.txtContraseña)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)

        btnIngresar.setOnClickListener {
            val usuarioIngresado = txtUsuario.text.toString()
            val contraseñaIngresada = txtContraseña.text.toString()

            val usuarioCorrecto = getString(R.string.user)
            val contraseñaCorrecta = getString(R.string.pass)

            if (usuarioIngresado == usuarioCorrecto && contraseñaIngresada == contraseñaCorrecta) {
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("nombre", getString(R.string.nombre))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }


        btnSalir.setOnClickListener {
            finish()
        }
    }
}
