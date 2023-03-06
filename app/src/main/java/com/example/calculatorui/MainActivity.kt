package com.example.calculatorui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvProblem: TextView = findViewById(R.id.tvProblem)
        var tvResult: TextView = findViewById(R.id.tvResult)

        val mbClear: MaterialButton = findViewById(R.id.mbClear)
        mbClear.setOnClickListener {
            tvProblem.text = ""
        }

        val mbFullClean: MaterialButton = findViewById(R.id.mbFullClean)
        mbFullClean.setOnClickListener {
            tvProblem.text = ""
            tvResult.text = ""
        }

        val mbLeftBracket: MaterialButton = findViewById(R.id.mbLeftBracket)
        mbLeftBracket.setOnClickListener {
            tvProblem.text = addToInputText("(")
        }

        val mbRightBracket: MaterialButton = findViewById(R.id.mbRightBracket)
        mbRightBracket.setOnClickListener {
            tvProblem.text = addToInputText(")")
        }

        val mbDivide: MaterialButton = findViewById(R.id.mbDivide)
        mbDivide.setOnClickListener {
            tvProblem.text = addToInputText("/")
        }

        val mbSeven: MaterialButton = findViewById(R.id.mbSeven)
        mbSeven.setOnClickListener {
            tvProblem.text = addToInputText("7")
        }

        val mbEight: MaterialButton = findViewById(R.id.mbEight)
        mbEight.setOnClickListener {
            tvProblem.text = addToInputText("8")
        }

        val mbNine: MaterialButton = findViewById(R.id.mbNine)
        mbNine.setOnClickListener {
            tvProblem.text = addToInputText("9")
        }

        val mbMultiplication: MaterialButton = findViewById(R.id.mbMultiplication)
        mbMultiplication.setOnClickListener {
            tvProblem.text = addToInputText("*")
        }

        val mbFour: MaterialButton = findViewById(R.id.mbFour)
        mbFour.setOnClickListener {
            tvProblem.text = addToInputText("4")
        }

        val mbFive: MaterialButton = findViewById(R.id.mbFive)
        mbFive.setOnClickListener {
            tvProblem.text = addToInputText("5")
        }

        val mbSix: MaterialButton = findViewById(R.id.mbSix)
        mbSix.setOnClickListener {
            tvProblem.text = addToInputText("6")
        }

        val mbPlus: MaterialButton = findViewById(R.id.mbPlus)
        mbPlus.setOnClickListener {
            tvProblem.text = addToInputText("+")
        }

        val mbOne: MaterialButton = findViewById(R.id.mbOne)
        mbOne.setOnClickListener {
            tvProblem.text = addToInputText("1")
        }

        val mbTwo: MaterialButton = findViewById(R.id.mbTwo)
        mbTwo.setOnClickListener {
            tvProblem.text = addToInputText("2")
        }

        val mbThree: MaterialButton = findViewById(R.id.mbThree)
        mbThree.setOnClickListener {
            tvProblem.text = addToInputText("3")
        }

        val mbMinus: MaterialButton = findViewById(R.id.mbMinus)
        mbMinus.setOnClickListener {
            tvProblem.text = addToInputText("-")
        }

        val mbZero: MaterialButton = findViewById(R.id.mbZero)
        mbZero.setOnClickListener {
            tvProblem.text = addToInputText("0")
        }

        val mbDot: MaterialButton = findViewById(R.id.mbDot)
        mbDot.setOnClickListener {
            tvProblem.text = addToInputText(".")
        }

        val mbEqual: MaterialButton = findViewById(R.id.mbEqual)
        mbEqual.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        var tvProblem: TextView = findViewById(R.id.tvProblem)
        return "${tvProblem.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        val tvProblem: TextView = findViewById(R.id.tvProblem)
        return tvProblem.text.toString()
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()

            if (result.isNaN()) {
                var tvResult: TextView = findViewById(R.id.tvResult)
                //Show error message
                tvResult.text = "Error"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.yellow))
            } else {
                var tvResult: TextView = findViewById(R.id.tvResult)
                //Show result
                tvResult.text = DecimalFormat("0.######").format(result).toString()
            }

        } catch (e: Exception) {
            var tvResult: TextView = findViewById(R.id.tvResult)
            //Show error message
            tvResult.text = "Error"
            tvResult.setTextColor(ContextCompat.getColor(this, R.color.yellow))
        }
    }
}