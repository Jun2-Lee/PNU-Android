package com.example.week2
class NotSmallLetterException(message: String): Exception(message)
fun change(letter: String): String{
    var not_small:String = ""
    var upper:String = ""
    try{
        for(ch in letter){
            if(ch.toInt() < 97 || ch.toInt() > 122){
                not_small += ch
            }
        }
        if (not_small != "") {
            throw NotSmallLetterException(not_small)
        }
        for(ch in letter){
            upper += (ch.toInt() - 32).toChar()
        }
    }
    catch(e:NotSmallLetterException){
        print("error with = " + e.message)
    }
    return upper;
}
fun main(){

        var a = "abcd"
        println(change(a))
        var b = "EfgH"
        println(change(b))
        var c = "!@%$"
        println(change(c))
}