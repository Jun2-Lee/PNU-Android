package com.example.androidlab

class Calculator(){
    private var count = 0
    private var list:MutableList<Double> = mutableListOf()
    private fun add(a:Double, b:Double){
        list.add(a+b)
    }
    private fun subtract(a:Double, b:Double){
        list.add(a-b)
    }
    private fun multiple(a:Double, b:Double){
        list.add(a*b)
    }
    private fun division(a:Double, b:Double){
        list.add(a/b)
    }

    fun cal(a:Double,b:Double,type:String){
        if(type == "add") {
            add(a,b)
            count++
        }
        if(type == "subtract") {
            subtract(a,b)
            count++
        }
        if(type == "multiple") {
            multiple(a,b)
            count++
        }
        if(type == "division"){
            if(b == 0.0) {
                println("ERROR : number can not be divided with zero")
            }
            else{
                division(a,b)
                count++
            }
        }
    }

    fun print_calculated_number(){
        println(list[count-1])
    }
    fun load(){
        for(num in list){
            println(num)
        }
    }
}

fun main(){
    var calculator = Calculator()
    calculator.cal(1.0,2.0,"add")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"subtract")
    calculator.print_calculated_number()
    calculator.cal(1.0,0.0,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"division")
    calculator.print_calculated_number()
    calculator.cal(1.0,10.0,"multiple")
    calculator.print_calculated_number()
    println("--------------")
    calculator.load()
}