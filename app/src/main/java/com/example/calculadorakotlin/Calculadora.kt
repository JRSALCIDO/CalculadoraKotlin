package com.example.calculadorakotlin

class Calculadora(var num1: Float, var num2: Float) {
    fun suma(): Float {
        return num1 + num2
    }

    fun resta(): Float {
        return num1 - num2
    }

    fun multiplicacion(): Float {
        return num1 * num2
    }

    fun division(): Float {
        if (num2 != 0f) {
            return num1 / num2
        } else {
            throw IllegalArgumentException("División por cero no está permitida")
        }
    }
}
