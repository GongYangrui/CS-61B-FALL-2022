package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {
    @Test
    public void addConstantTest() {
        IntList L = new IntList(10, null);
        L = new IntList(20, L);
        L = new IntList(30, L);

        IntListExercises.addConstant(L, 5);

        assertEquals(35, L.first);
        assertEquals(25, L.rest.first);
        assertEquals(15, L.rest.rest.first);
    }

    @Test
    public void firstDigitEqualsLastDigitTest() {
        assertEquals(true, IntListExercises.firstDigitEqualsLastDigit(101));
        assertEquals(true, IntListExercises.firstDigitEqualsLastDigit(3513));
        assertEquals(false, IntListExercises.firstDigitEqualsLastDigit(123));
    }

    @Test
    public void maxTest() {
        IntList L = new IntList(50, null);
        L = new IntList(20, L);
        L = new IntList(30, L);

        assertEquals(50, IntListExercises.max(L));
    }

    @Test
    public void setToZeroIfMaxFELTest() {
        IntList L = new IntList(50, null);
        L = new IntList(20, L);
        L = new IntList(30, L);

        IntListExercises.setToZeroIfMaxFEL(L);
        assertEquals(30, L.first);
        assertEquals(20, L.rest.first);
        assertEquals(50, L.rest.rest.first);
    }

    @Test
    public void squarePrimestest() {
        IntList L = new IntList(2, null);
        L = new IntList(6, L);
        L = new IntList(9, L);

        assertEquals(true, IntListExercises.squarePrimes(L));
    }
}
