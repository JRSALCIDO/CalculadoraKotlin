package com.example.calculadorakotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var lblResultado: TextView
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnSalir: Button

    private var calculadora: Calculadora? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)


        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        lblResultado = findViewById(R.id.lblResultado)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnSalir = findViewById(R.id.btnSalir)

        btnSuma.setOnClickListener {
            val num1 = txtNum1.text.toString().trim()
            val num2 = txtNum2.text.toString().trim()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Ambos campos contienen valores no vacíos
                calculadora = Calculadora(num1.toFloat(), num2.toFloat())
                val resultado = calculadora?.suma()
                lblResultado.text = resultado.toString()
            }  else {
                Toast.makeText(this, "Ingrese Ambos Numeros", Toast.LENGTH_SHORT).show()
            }


        }

        btnResta.setOnClickListener {
            val num1 = txtNum1.text.toString().trim()
            val num2 = txtNum2.text.toString().trim()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Ambos campos contienen valores no vacíos
                calculadora = Calculadora(txtNum1.text.toString().toFloat(), txtNum2.text.toString().toFloat())
                val resultado = calculadora?.resta()
                lblResultado.text = resultado.toString()
            }  else {
                Toast.makeText(this, "Ingrese Ambos Numeros", Toast.LENGTH_SHORT).show()
            }

        }

        btnMult.setOnClickListener {
            val num1 = txtNum1.text.toString().trim()
            val num2 = txtNum2.text.toString().trim()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Ambos campos contienen valores no vacíos
                calculadora = Calculadora(txtNum1.text.toString().toFloat(), txtNum2.text.toString().toFloat())
                val resultado = calculadora?.multiplicacion()
                lblResultado.text = resultado.toString()
            }  else {
                Toast.makeText(this, "Ingrese Ambos Numeros", Toast.LENGTH_SHORT).show()
            }

        }

        btnDiv.setOnClickListener {
            val num1 = txtNum1.text.toString().trim()
            val num2 = txtNum2.text.toString().trim()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                // Ambos campos contienen valores no vacíos
                calculadora = Calculadora(txtNum1.text.toString().toFloat(), txtNum2.text.toString().toFloat())
                val resultado = calculadora?.division()
                if (resultado != null) {
                    lblResultado.text = resultado.toString()
                } else {
                    lblResultado.text = "Error: División por cero"
                }
            }  else {
                Toast.makeText(this, "Ingrese Ambos Numeros", Toast.LENGTH_SHORT).show()
            }

        }

        btnLimpiar.setOnClickListener {
            txtNum1.text.clear()
            txtNum2.text.clear()
            lblResultado.text = ""
        }

        btnSalir.setOnClickListener {
            finish()
        }

    }
}
