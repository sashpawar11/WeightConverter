package com.sash.weightconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    lateinit var inputwt1 : EditText
    lateinit var wt1header : TextView
    lateinit var wt2header : TextView
    lateinit var convertBtn : Button
    lateinit var resultView : TextView
    var isKg = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        convertBtn = findViewById(R.id.convBtn)
        inputwt1 = findViewById(R.id.inputWt)
        isKg = true
        inputwt1.setHint("Enter Weight In Kilograms")

    }

    fun kgTolb(view: View)
    {
        try {

            inputwt1 = findViewById(R.id.inputWt)
            resultView = findViewById(R.id.resultWt)
            var w1text = inputwt1.text.toString()
            var w1 = w1text.toInt()
            if(isKg) {
                var convResult = (w1 * 2.2046)
                var result = String.format("%.2f", convResult)
                resultView.text = "${result} lb"
            }
            else
            {
                var convResult = (w1 / 2.2046)
                var result = String.format("%.2f", convResult)
                resultView.text = "${result} kg"
            }
        }
        catch(e: Exception)
        {
            Toast.makeText(applicationContext, "Please enter a value!", Toast.LENGTH_SHORT)
                .show()
        }

    }

    fun changeConv(view: View)
    {
        isKg = !isKg
        wt1header = findViewById(R.id.wt1text)
        wt2header = findViewById(R.id.wt2txt)
        inputwt1 = findViewById(R.id.inputWt)
        resultView = findViewById(R.id.resultWt)
        inputwt1.text = null
        resultView.text = null
        if(!isKg) {
            wt1header.text = "POUNDS"
            wt2header.text = "WEIGHT IN KILOGRAMS"
            inputwt1.setHint("Enter Weight in Pounds")
        }
        else
        {
            wt1header.text = "KILOGRAMS"
            wt2header.text = "WEIGHT IN POUNDS"
            inputwt1.setHint("Enter Weight in Kilograms")
        }


    }
}