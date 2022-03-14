package com.example.androidlab

import java.util.*


enum class Grade{A,B,C,D,E,F}


class MyAccount(){
    var sc: Scanner = Scanner(System.`in`)

    var name:String = "KIM"
    var money:Int = 0
    var Credit = Grade.C

    fun Information(){
        println("계좌정보는 다음과 같습니다")
        println("|이름: $name|")
        println("|계좌잔액:$money|")
        println("|신용등급:$Credit|")
    }
    fun Deposite(){
        println("입금하실 금액을 말하세요.")
        var dep = sc.nextInt()
        money += dep
        if(money >= 0){
            upGrade()
        }
        println("$dep 원을 입금하였습니다. 잔액 : $money")
    }
    fun Withdraw(){
        if(Credit == Grade.F) {
            println("동결된 계좌에서 출금하실 수 없습니다")
            return
        }
        println("출금하실 금액을 말하세요.")
        var wit = sc.nextInt()
        money -= wit
        if(money <0 && money >= -1000){
            println("계좌가 마이너스 되었습니다.")
            downGrade()
        }
        if(money < -1000){
            println("잔액이 부족합니다.")
            println("계좌가 마이너스 되었습니다.")
            downGrade()
        }
        println("$wit 원을 출금하였습니다. 잔액 : $money")

    }

    fun downGrade(){
        when(Credit){
            Grade.A -> {
                println("신용등급이 'A->B'로 한단계 떨어집니다.")
                Credit = Grade.B
            }
            Grade.B -> {
                println("신용등급이 'B->C'로 한단계 떨어집니다.")
                Credit = Grade.C
            }
            Grade.C -> {
                println("신용등급이 'C->D'로 한단계 떨어집니다.")
                Credit = Grade.D
            }
            Grade.D -> {
                println("신용등급이 'D->E'로 한단계 떨어집니다.")
                Credit = Grade.E
            }
            Grade.E -> {
                println("신용등급이 'E->F'로 한단계 떨어집니다.")
                println("최저 등급의 신용을 가지고 있습니다.")
                println("계좌가 동결됩니다.")
                Credit = Grade.F
            }
        }
    }

    fun upGrade(){
        when(Credit){
            Grade.B -> {
                println("신용등급이 'B->A'로 한단계 상승합니다.")
                Credit = Grade.A
            }
            Grade.C -> {
                println("신용등급이 'C->B'로 한단계 상승합니다.")
                Credit = Grade.B
            }
            Grade.D -> {
                println("신용등급이 'D->C'로 한단계 상승합니다.")
                Credit = Grade.C
            }
            Grade.E -> {
                println("신용등급이 'E>D'로 한단계 상승합니다.")
                Credit = Grade.D
            }
            Grade.F -> {
                println("동결계좌가 열렸습니다.")
                println("신용등급이 'F->E'로 한단계 상승합니다.")
                Credit = Grade.E
            }
        }
    }
}
fun main(){
    var select:String
    var ac = MyAccount()

    var sc: Scanner = Scanner(System.`in`)
    while(true) {
        println("----선택하세요----")
        println("|(I) 계좌정보    |")
        println("|(D) 입금       |")
        println("|(W) 출금       |")
        println("|(E) 종료       |")
        println("---------------")
        select = sc.nextLine()
        when(select){
            "I" -> ac.Information()
            "D" -> ac.Deposite()
            "W" -> ac.Withdraw()
            "E" -> break
        }
    }
}