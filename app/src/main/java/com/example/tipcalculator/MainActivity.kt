package com.example.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var calculateBtn: Button
    private lateinit var costOfService: EditText
    private lateinit var tipOptions: RadioGroup
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var roundSwitch: Switch
    private lateinit var tipAmount: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn = findViewById(R.id.calculateButton)
        costOfService = findViewById(R.id.cost_of_service)
        tipOptions = findViewById(R.id.tipOption)
        roundSwitch = findViewById(R.id.switchButton)
        tipAmount = findViewById(R.id.tipAmountText)

        calculateBtn.setOnClickListener {
            val text = costOfService.text.toString()
            var tipPercent = 0f
            var totalTip = 0f
            when (tipOptions.checkedRadioButtonId) {
                R.id.twentyPercent -> tipPercent = 0.2f
                R.id.eighteenPercent -> tipPercent = 0.18f
                R.id.fifteenPercent -> tipPercent = 0.15f
                else -> tipPercent = 0.2f
            }
            totalTip = text.toFloat() * tipPercent
            if (roundSwitch.isChecked) {
                totalTip = totalTip.roundToInt().toFloat()
            }
            tipAmount.text = "Tip amount: ${totalTip.toString()}"
        }
    }
}