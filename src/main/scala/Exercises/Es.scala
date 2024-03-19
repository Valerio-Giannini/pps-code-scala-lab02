package Exercises

import u02.Values.s
import u02.AnonymousFunctions.i
import scala.compiletime.ops.boolean

object Exercise extends App:

    val f: Int => String = _ match
    case n if n > 0 =>"POSITIVE"
    case 0 => "POSITIVE"
    case _ => "NEGATIVE"
    println(f(2))

    def positiveNum (x:Int) : String = x match
        case x if x > 0 => "Positive"
        case 0 => "Positive"
        case _ => "Negative"
        println(positiveNum(2))

    val empty: String => Boolean = _ == ""
    val neg: (String => Boolean) => (String => Boolean) =
        f => (i => !f(i))
         
    def mNeg(f: (String => Boolean)): (String => Boolean) = 
        //devo tornare una funzione che accetta una stringa e torna un booleano
        string => !f(string)
    
    def genEmpty[S](s:S): Boolean = s == ""

    def genNeg [S](f: (S => Boolean)): (S => Boolean) =
        !f(_)

    val notEmpty = genNeg(genEmpty)
    println(notEmpty(""))     

    //Currying
    val p1: (Int, Int, Int) => Boolean =
        (x, y, z) => x <= y && y == z

   
        
    //Functional Composition
    def comp(f: (Int => Int), g: (Int => Int)): (Int => Int) =
        x => f(g(x))

    val compose = comp(_-1,_*2)(5)
    println(compose)

    //Functional Composition (Generic)
    def gComp[A , B, C](g: (A => B), f: (B => C)): (A => C) =
        x => f(g(x))
    
    val gCompose = gComp((_: String) + "Hello", _== "ciaoHello")("ciao")
    println(gCompose)

    //GCD
    def gcd(x: Int, y: Int): Int =
        y match
            case y if y == 0 => x
            case _ => gcd(y, x % y)
    val testGcd = gcd(8, 12)
    println(testGcd)



     
        
        
        
        
        
        

        