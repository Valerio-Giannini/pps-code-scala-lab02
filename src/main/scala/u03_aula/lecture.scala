package u03_aula

object Sequences: //Essentially, generic linkedlist

    enum Sequence[A]:
        case Nil()
        case Cons(head: A, tail: Sequence[A])

    object Sequence:
        
        def isEmpty[A] (s: Sequence[A]): Boolean = 
            s match
                case Nil() => true
                case _ => false
        
        def sum (s: Sequence[Int]): Int = 
            s match
                case Nil() => 0
                case Cons(h, t) => h + sum(t) //NON TAIL RECURSION

        def map[A, B](s: Sequence[A], f: A => B): Sequence[B] = 
            s match
                case Nil() => Nil()
                case Cons(h, t) => Cons(f(h), map(t, f))
            

            
            

@main def trySeqyences() =
     import Sequences.* 
     import Sequence.* 

     val emptySeq = Nil()
     val seq = Cons("10", Nil())
