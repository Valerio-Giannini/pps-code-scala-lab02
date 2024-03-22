package Exercises

import u02.Values.s
import u02.AnonymousFunctions.i
import scala.compiletime.ops.boolean
import java.awt.Shape
import scala.runtime.stdLibPatches.language.`3.2`

object Exercise extends App:

    val f: Int => String = _ match
    case n if n >= 0 =>"POSITIVE"
    case _ => "NEGATIVE"
    println(f(2))

    def positiveNum (x:Int) : String = x match
        case x if x >= 0 => "Positive"
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
    val p1: (Int, Int, Int) => Boolean = //non Curried
        (x, y, z) => x <= y && y == z
    val p2: Int => Int => Int => Boolean = //Curried
        x => y => z => x <= y && y == z
    
    def p3(x: Int, y: Int, z: Int): Boolean = //non Curried
        x <= y && y == z
    def p4(x: Int)(y: Int)(z: Int): Boolean = // Curried
        x <= y && y == z 

   
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
    @annotation.tailrec
    def gcd(x: Int, y: Int): Int = 
        y match
            case y if y == 0 => x
            case _ => gcd(y, x % y)
    val testGcd = gcd(8, 12)
    println(testGcd)

    //Perimeter shape
    enum Shape:
        case Rectangle (l1: Double, l2: Double)
        case Circle (ray: Double)
        case Square (l: Double)
    
    def perimeter(s: Shape): Double =
        s match
            case Shape.Rectangle(l1, l2) => (l1 + l2) * 2
            case Shape.Circle(ray) => 2 * ray * 3.14
            case Shape.Square(l) => l * 4
    
    def area(s: Shape): Double =
        s match
            case Shape.Rectangle(l1, l2) => l1 * l2
            case Shape.Circle(ray) => 3.14 * (math.pow(ray, 2))
            case Shape.Square(l) => math.pow(l, 2)
            
    def scale(s: Shape, alpha: Double): Shape =
        s match
            case Shape.Rectangle(l1, l2) => Shape.Rectangle(l1 * alpha, l2 * alpha)
            case Shape.Circle(ray) => Shape.Circle(ray * alpha)
            case Shape.Square(l) => Shape.Square(l * alpha)

end Exercise

        
        






     
        
        
        
        
        
        

        