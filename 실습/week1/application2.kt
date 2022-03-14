package com.example.androidlab

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.max


fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val N:Int = readLine().toInt()

    var T = IntArray(N+10)
    var P = IntArray(N+10)
    var dp = IntArray(N+10)

    var max = 0

    var i = 0
    while(i < N){
        var temp = readLine()!!.split(' ')
        T[i] = temp[0].toInt()
        P[i] = temp[1].toInt()
        i++
    }

    for (i in T.indices) {
        val nx = i + T[i]
        if (i > 0) dp[i] = max(dp[i], dp[i-1])
        if (nx > N) continue
        dp[nx] = max(dp[nx], dp[i] + P[i])
    }
    max = dp[N]

    println(max)

    close()
}