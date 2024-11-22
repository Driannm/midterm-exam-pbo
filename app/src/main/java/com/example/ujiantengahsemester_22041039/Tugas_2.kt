package com.example.ujiantengahsemester_22041039

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Tugas_2 : AppCompatActivity() {

    private lateinit var editTextTemperature: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas2)

        editTextTemperature = findViewById(R.id.editTextTemperature)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        textViewResult = findViewById(R.id.textViewResult)
        val buttonConvert: Button = findViewById(R.id.buttonConvert)

        // Setup spinner with temperature units
        val units = arrayOf("Celsius", "Fahrenheit", "Kelvin")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        buttonConvert.setOnClickListener {
            convertTemperature()
        }
    }

    private fun convertTemperature() {
        val input = editTextTemperature.text.toString()
        if (input.isNotEmpty()) {
            val temperature = input.toDouble()
            val fromUnit = spinnerFrom.selectedItem.toString()
            val toUnit = spinnerTo.selectedItem.toString()
            val result = when (fromUnit) {
                "Celsius" -> when (toUnit) {
                    "Fahrenheit" -> (temperature * 9/5) + 32
                    "Kelvin" -> temperature + 273.15
                    else -> temperature
                }
                "Fahrenheit" -> when (toUnit) {
                    "Celsius" -> (temperature - 32) * 5/9
                    "Kelvin" -> (temperature - 32) * 5/9 + 273.15
                    else -> temperature
                }
                "Kelvin" -> when (toUnit) {
                    "Celsius" -> temperature - 273.15
                    "Fahrenheit" -> (temperature - 273.15) * 9/5 + 32
                    else -> temperature
                }
                else -> 0.0
            }
            textViewResult.text = "Hasil: $result $toUnit"
        } else {
            textViewResult.text = "Masukkan suhu yang valid"
        }
    }
}
