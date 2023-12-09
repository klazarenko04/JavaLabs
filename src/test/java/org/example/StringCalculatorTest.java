package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testMoreThanTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"));
    }

    @Test
    public void testFourNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(10, calculator.add("1,2,3,4"));
    }
}