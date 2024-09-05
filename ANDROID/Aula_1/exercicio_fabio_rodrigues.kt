package org.kotlinlang.play         // 1

fun main() {                        // 2
    // Exercicio 1
    val num1: Int = 19
    val num2: Int = 4
    print("Soma : ")
	println(num1+num2)

    // Exercicio 2
    val num1: Int = 19
    val num2: Int = 4
    val num3: Int = 10
    var media: Double = (num1*0.2) + (num2*0.3) + (num3*0.5)
	println("Media: $media")

    // Exercicio 3
    var num1: Int = 19
    var num2: Int = 4
    num2 = num1.apply{num1 = num2}
    println("numero 1: $num1 \nnumero 2: $num2")

    // Exercicio 4
    var produto1: Double = 12.99
    var produto2: Double = 1.95
    var produto3: Double = 4.23
    var total: Double = produto1 + produto2 + produto3
    var media: Double = total-(total*0.1)
    
	println("Media: $media")

    // Exercicio 5
    var num1: Int = 19
    var num2: Int = 4
	
    if(num1 > num2){
        println(num1)
    }else{
        println(num2)
    }

    // Exercicio 6
    var num1: Int = 4
    var num2: Int = 8
    var num3: Int = 9
	
    if(num1 < num2 && num1 < num3){
        println(num1)
    }else if (num2 < num1 && num2 < num3){
        println(num2)
    }else{
        println(num3)
    }

    // Exercicio 7
    var num1: Int = 9
    var num2: Int = 4
    var num3: Int = 8

    if(num1 > num2 && num1 > num3){
        if(num2 > num3){
            println("$num1 $num2 $num3")
        }else{
            println("$num1 $num3 $num2")
        }
    }else if (num2 > num1 && num2 > num3){
        if(num1 > num3){
        	println("$num2 $num1 $num3")
        }
        else{
            println("$num2 $num3 $num1")
        }
    }else{
       if(num2 > num1){
        	println("$num3 $num2 $num1")
        }else{
            println("$num3 $num1 $num2")
        }
    }

    // Exercicio 8
    for (i in 1..250) {
    	println(i)
	}

    // Exercicio 9
    for (i in 2..400 step 2) {
    	println(i)
	}

    // Exercicio 10
    for (i in 531..750) {
        if(!(i % 2 == 0))
    		println(i)
	}

    // Exercicio 11
    var total = 0
    for (i in 1..100) {
        total += i
    	println(i)
	}
    println(total)

    // Exercicio 12

}