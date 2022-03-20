package com.example.week2

import java.util.*

private lateinit var map: Array<IntArray>
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var N = 0
private var M = 0
private val virusList = ArrayList<Virus>()
private var answer = 0


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    map = Array(N) { IntArray(M) }
    for (i in 0..(N-1)) {
        for (j in 0..(M-1)) {
            map[i][j] = sc.nextInt()
            if (map[i][j] == 2) {
                virusList.add(Virus(i, j))
            }
        }
    }
    dfs(0)
    println(answer)
}

private fun dfs(count: Int) {
    if (count == 3) { //  int[][] tmpMap = map.clone();  deep copy 안됨
        val tmpMap = Array(N) { IntArray(M) }
        for (i in 0..(N - 1)) {
            for (j in 0..(M - 1)) {
                tmpMap[i][j] = map[i][j]
            }
        }
        for (virus in virusList) {
            spreadVirus(virusList, tmpMap)
        }
        countSafeArea(tmpMap)
        return
    }
    for (i in 0..N-1) {
        for (j in 0..M-1) {
            if (map[i][j] == 0) {
                map[i][j] = 1
                dfs(count + 1)
                map[i][j] = 0
            }
        }
    }

}

fun print_map(map: Array<IntArray>){
    for (i in 0..N + 1) {
        for (j in 0..M + 1) {
            print(map[i][j])
            print(" ")
        }
        println()
    }
    println()
}



private fun spreadVirus(virusList: ArrayList<Virus>, map: Array<IntArray>) {
    var queue: Queue<Virus> = LinkedList()
    for(virus in virusList){
        queue.offer(virus)
    }
    while(!queue.isEmpty()){
        var x = queue.peek().x
        var y = queue.peek().y
        queue.poll()

        for(i in 0..3){
            var x2 = x + dx[i]
            var y2 = y + dy[i]

            if(x2 >= 0 && x2 < N && y2 >= 0 && y2 < M){
                if(map[x2][y2] == 0){
                    map[x2][y2] = 2
                    queue.offer(Virus(x2,y2))
                }
            }
        }

    }


}

private fun countSafeArea(map: Array<IntArray>) {
    var count = 0
    for (i in 0..N-1) {
        for (j in 0..M-1) {
            if (map[i][j] == 0) {
                count++
            }
        }
    }
    answer = answer.coerceAtLeast(count)
}

data class Virus(var x: Int, var y: Int)