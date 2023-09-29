 fun main(){

     var map = mutableMapOf<String,String>("gujarat" to "surat", "utter pradesh" to "banarsa","madhya pradesh" to "satna")
     for (item in map.keys){
         println("states:${item} , city:${map[item]}")
     }

   println("hello word")
   println("${start()}")
//    print("Enter the number1 :")
//   var n1= readLine()!!.toInt()

//   print("enter num1:")
//   var num1= readLine()!!.toInt()
//     print("enter num2:")
//     var num2= readLine()!!.toInt()
//     var add = num1+num2
//     println("addintion:$add")

   var n1 :Float=2.2f
   var n2 :Float=2.3f
   var multi = n1*n2
   println("multiplication :${multi}")

   val char = 'a'
   val asciivalue= char.toInt()
     println("ascii code of char: $asciivalue")

     var num = 7
    if (num % 2 == 0) {
        println("$num is even number ")
    } else {
        println("$num is odd number")
    }

     var max= maxOf(2,10,500,300)
     println("maximum value:$max")

     var divident = 110
     var divisor=3
     val quotient= divident /divisor
     val remainder = divident%divisor
     println("$quotient")
     println("$remainder")

     var str= "komal and kashish both are good friend"
     var c = 'k'
     var frequency=0
     for (i in str.indices){
         if (c==str[i]){
            frequency++
         }
     }
     println("Frequency $c is :$frequency")

 }
 fun start():String
 {
     return "OK"
 }





