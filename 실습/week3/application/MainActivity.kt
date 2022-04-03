package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class NullException :Exception()
class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv: Button
    lateinit var btnRem : Button; lateinit var btnChg : Button
    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 : String
    lateinit var temp : String
    var result : Int? = null
    var count : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "${count}회 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnRem = findViewById(R.id.BtnRem)
        btnChg = findViewById(R.id.BtnChg)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                result = Integer.parseInt(num1) + Integer.parseInt(num2)
                count++
                title = "${count}회 계산기"
                edit1.setText(result.toString())
                edit2.setText("")
                textResult.text = "계산 결과 : " + result.toString()
            } catch(e: NullException){
            }
        }

        btnSub.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                result = Integer.parseInt(num1) - Integer.parseInt(num2)
                count++
                title = "${count}회 계산기"
                edit1.setText(result.toString())
                edit2.setText("")
                textResult.text = "계산 결과 : " + result.toString()
            } catch(e: NullException){
            }
        }

        btnMul.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                result = Integer.parseInt(num1) * Integer.parseInt(num2)
                count++
                title = "${count}회 계산기"
                edit1.setText(result.toString())
                edit2.setText("")
                textResult.text = "계산 결과 : " + result.toString()
            }catch(e: NullException){
            }
        }

        btnDiv.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                result = Integer.parseInt(num1) / Integer.parseInt(num2)
                count++
                title = "${count}회 계산기"
                edit1.setText(result.toString())
                edit2.setText("")
                textResult.text = "계산 결과 : " + result.toString()

            }catch(e:NullException){
            }
        }
        btnRem.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                result = Integer.parseInt(num1) % Integer.parseInt(num2)
                count++
                title = "${count}회 계산기"
                edit1.setText(result.toString())
                edit2.setText("")
                textResult.text = "계산 결과 : " + result.toString()

            }catch(e:NullException){
            }
        }
        btnChg.setOnClickListener{view ->
            try {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if(num1 == "" || num2 == ""){
                    throw NullException()
                }
                temp = num1
                num1 = num2
                num2 = temp
                edit1.setText(num1)
                edit2.setText(num2)
            }catch(e:NullException){
            }
        }
    }
}