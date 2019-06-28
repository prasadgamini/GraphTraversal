package onv.recursive;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

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
        LocalDateTime start = LocalDateTime.now();
        int sixFactorial = factorial.compute(6);
        Duration duration = Duration.between(start, LocalDateTime.now());
        System.out.println(duration.toMillis());
        assertEquals(720, sixFactorial);
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
        LocalDateTime start = LocalDateTime.now();
        int sixFactorial = factorial.computeWithAccumulator(6);
        Duration duration = Duration.between(start, LocalDateTime.now());
        System.out.println(duration.toMillis());
        assertEquals(720, sixFactorial);
    }

    @Test
    public void durationTest() {
        Factorial factorial = new Factorial();
        LocalDateTime start = LocalDateTime.now();
        int sixFactorial = 3628800;//factorial.compute(10);
        Duration duration = Duration.between(start, LocalDateTime.now());
        System.out.println("Without Accumulator: " + duration.toMillis());
        assertEquals(3628800, sixFactorial);

        start = LocalDateTime.now();
        sixFactorial = factorial.computeWithAccumulator(10);
        duration = Duration.between(start, LocalDateTime.now());
        System.out.println("With Accumulator: " + duration.toMillis());
        assertEquals(3628800, sixFactorial);

    }
}