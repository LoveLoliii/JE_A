package com.summersama.je_a.utils

public fun main(args:Array<String>) {
    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    val x = Person("x");
  //  x 说 "呵呵"
   var xx =  ConstantUtils.QUERY_URL;
    print(xx)
}

class Person(val name:String) {
    infix fun 说(word: String){
        println("\"$name 说 $word\"");
    }
}