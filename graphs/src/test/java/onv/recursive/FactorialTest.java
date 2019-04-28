package onv.recursive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FactorialTest {

    @Test
    public void testFactorialWithOne() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.compute(1));
    }

    @Test
    public void testFactorialWithTwo() {
        Factorial factorial = new Factorial();
        assertEquals(2, factorial.compute(2));
    }

    @Test
    public void testFactorialWithThree() {
        Factorial factorial = new Factorial();
        assertEquals(6, factorial.compute(3));
    }

    @Test
    public void testFactorialWithSix() {
        Factorial factorial = new Factorial();
        assertEquals(720, factorial.compute(6));
    }

    @Test
    public void testAccumulatorFactorialWithOne() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.computeWithAccumulator(1));
    }

    @Test
    public void testAccumulatorFactorialWithTwo() {
        Factorial factorial = new Factorial();
        assertEquals(2, factorial.computeWithAccumulator(2));
    }

    @Test
    public void testAccumulatorFactorialWithThree() {
        Factorial factorial = new Factorial();
        assertEquals(6, factorial.computeWithAccumulator(3));
    }

    @Test
    public void testAccumulatorFactorialWithSix() {
        Factorial factorial = new Factorial();
        assertEquals(720, factorial.computeWithAccumulator(6));
    }
}