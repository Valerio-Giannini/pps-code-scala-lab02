package u03_aula

import org.junit.Test
import org.junit.Assert.* 

class SequencesTest:
    import Sequences.* 
    import Sequence.* 

    val seq0 = Nil()
    val seq = Cons(10, Cons(20,Nil()))

    @Test def testIsEmpty() =
        assertTrue(isEmpty(seq0))
        assertFalse(isEmpty(seq))