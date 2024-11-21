package Mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class MultiplicationTest {

    @Test
    void multiplication() {
        assertEquals(20, Multiplication.multiplication(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplication(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplication(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplication(4, 0), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingLoop() {
        assertEquals(20, Multiplication.multiplyUsingLoop(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplyUsingLoop(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplyUsingLoop(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplyUsingLoop(4, 0), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingRecursion() {
        assertEquals(20, Multiplication.multiplyUsingRecursion(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplyUsingRecursion(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplyUsingRecursion(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplyUsingRecursion(4, 0), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingShift() {
        assertEquals(20, Multiplication.multiplyUsingShift(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplyUsingShift(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplyUsingShift(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplyUsingShift(4, 0), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingLogs() {
        assertEquals(20, Multiplication.multiplyUsingLogs(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplyUsingLogs(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplyUsingLogs(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplyUsingLogs(4, 0), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingFFT() {
        assertEquals("20", Multiplication.multiplyUsingFFT("4", "5"), "4 * 5 should equal 20");
        assertEquals("-12", Multiplication.multiplyUsingFFT("4", "-3"), "4 * -3 should equal -12");
        assertEquals("0", Multiplication.multiplyUsingFFT("0", "5"), "0 * 5 should equal 0");
        assertEquals("0", Multiplication.multiplyUsingFFT("4", "0"), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingLoopWithStringInput() {
        assertEquals("20", Multiplication.multiplyUsingLoopWithStringInput("4", "5"), "4 * 5 should equal 20");
        assertEquals("-12", Multiplication.multiplyUsingLoopWithStringInput("4", "-3"), "4 * -3 should equal -12");
        assertEquals("0", Multiplication.multiplyUsingLoopWithStringInput("0", "5"), "0 * 5 should equal 0");
        assertEquals("0", Multiplication.multiplyUsingLoopWithStringInput("4", "0"), "4 * 0 should equal 0");
    }

    @Test
    void multiplyUsingLoopWithIntegerInput() {
        assertEquals(20, Multiplication.multiplyUsingLoopWithIntegerInput(4, 5), "4 * 5 should equal 20");
        assertEquals(-12, Multiplication.multiplyUsingLoopWithIntegerInput(4, -3), "4 * -3 should equal -12");
        assertEquals(0, Multiplication.multiplyUsingLoopWithIntegerInput(0, 5), "0 * 5 should equal 0");
        assertEquals(0, Multiplication.multiplyUsingLoopWithIntegerInput(4, 0), "4 * 0 should equal 0");
    }
}