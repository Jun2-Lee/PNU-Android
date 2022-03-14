package com.example.androidlab

import java.util.*

fun main(){
    var num = 0
    var pairList: MutableList<Int> = mutableListOf()

    var sc:Scanner = Scanner(System.`in`)
    num = sc.nextLine().toInt()

    for(i:Int in 0..num-1 step(1)){
        var temp = sc.nextLine().toInt()
        pairList.add(temp)
    }

    for(i: Int in 0..num-1 step(1)){
        print("Pairs for " + pairList[i] + " : ")
        var j = 1
        while(j < pairList[i]/2 + 1){
            var temp = pairList[i] - j
            if(pairList[i]-j != j) {
                if(j!=1)
                    print(",")
                print("(" + j + " " + temp + ")")


            }
            j++
        }
        println()
    }
}