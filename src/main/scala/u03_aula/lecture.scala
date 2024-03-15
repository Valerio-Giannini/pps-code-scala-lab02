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
            

@main def trySeqyences() =
     import Sequences.* 
     import Sequence.* 

     val emptySeq = Nil()
     val seq = Cons("10", Nil())
