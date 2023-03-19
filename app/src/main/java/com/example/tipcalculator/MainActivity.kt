package com.example.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var unitvalue: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var calcButton: Button
    private lateinit var roundUpSwitch: Switch
    private lateinit var convAmountText: TextView
    private var convAmount = 0.0
    private var convPercent = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        unitvalue = findViewById(R.id.unitValue)
        calcButton = findViewById(R.id.calculateButton)
        radioGroup = findViewById(R.id.option)
        roundUpSwitch = findViewById(R.id.switchButton)
        convAmountText = findViewById(R.id.result)

        calcButton.setOnClickListener {
            val cost = unitvalue.text.toString().toDoubleOrNull() ?: 0.0
            val checkedRadioButton = radioGroup.checkedRadioButtonId

            when (checkedRadioButton) {
                R.id.mm_oz -> {
                    convPercent = if (roundUpSwitch.isChecked) {
                        100 / 3.38
                    } else {
                        3.38 / 100
                    }
                }
                R.id.cups_g -> {
                    convPercent = if (roundUpSwitch.isChecked) {
                        0.0042
                    } else {
                        240.0
                    }
                }
                else -> {
                    convPercent = 0.0
                }
            }

            convAmount = cost * convPercent

            convAmountText.text = convAmount.toString()
        }
    }
}