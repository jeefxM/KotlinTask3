package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var isNewNum: Boolean = true
    var oldNumber = ""
    var op = "+"
    private var finalNum: EditText =findViewById(R.id.TextView1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun numberEvent(view: View) {

        if(isNewNum){
            finalNum.setText("")
        }
        isNewNum = false

        // Normal Buttons
        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnOne = findViewById<Button>(R.id.btnOne)
        val btnTwo = findViewById<Button>(R.id.btnTwo)
        val btnThree = findViewById<Button>(R.id.btnThree)
        val btnFour = findViewById<Button>(R.id.btnFour)
        val btnFive = findViewById<Button>(R.id.btnFive)
        val btnSix = findViewById<Button>(R.id.btnSix)
        val btnSeven = findViewById<Button>(R.id.btnSeven)
        val btnEight = findViewById<Button>(R.id.btnEight)
        val btnNine = findViewById<Button>(R.id.btnNine)

        // operand Buttons
        val btnDot = findViewById<Button>(R.id.btnDot)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnPlusMinus = findViewById<Button>(R.id.btnPlusMinus)


        var btnClick: String = finalNum.text.toString()
        var btnSelect: Button = view as Button



        when(btnSelect.id){
            btnZero.id -> {btnClick += "0"}
            btnOne.id -> {btnClick += "1"}
            btnTwo.id -> {btnClick += "2"}
            btnThree.id -> {btnClick += "3"}
            btnFour.id -> {btnClick += "4"}
            btnFive.id -> {btnClick += "5"}
            btnSix.id -> {btnClick += "6"}
            btnSeven.id -> {btnClick += "7"}
            btnEight.id -> {btnClick += "8"}
            btnNine.id -> {btnClick += "9"}
            btnDot.id ->{btnClick += "."}
            btnPlusMinus.id -> {btnClick = "-${btnClick}"}
        }

        finalNum.setText(btnClick)


    }

    fun operandOperator(view: View) {
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        isNewNum = true
        oldNumber = finalNum.text.toString()
        var btnSelect: Button = view as Button
        when(btnSelect.id){
            btnPlus.id -> {op = "+"}
            btnMinus.id -> {op = "-"}
            btnMultiply.id -> {op = "*"}
            btnDivide.id -> {op = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newNumber: String = finalNum.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
        }
        finalNum.setText(result.toString())
    }

    fun clearEvent(view: View) {
        finalNum.setText("0")
        isNewNum = true
    }

    fun percentageEvent(view: View) {
        var no = finalNum.text.toString().toDouble() / 100
        finalNum.setText(no.toString())
        isNewNum = true
    }

}