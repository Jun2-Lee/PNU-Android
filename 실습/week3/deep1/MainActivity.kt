package com.example.deep1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

lateinit var linLayer : LinearLayout
lateinit var but : Button
var count : Int = 0
var one_touch: Boolean = true
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linLayer = findViewById(R.id.LinLay)
        but = findViewById(R.id.Button)
        but.setOnTouchListener{view, motionEvent ->
            if(one_touch) {
                if (count % 3 == 1) {
                    count++
                    linLayer.setBackgroundColor(Color.parseColor("#FF0000"))
                    false
                } else if (count % 3 == 2) {
                    count++
                    linLayer.setBackgroundColor(Color.parseColor("#00FF00"))
                    false
                } else if (count % 3 == 0) {
                    count++
                    linLayer.setBackgroundColor(Color.parseColor("#0000FF"))
                    false
                }
            }
            one_touch = !one_touch
        false}
    }
}