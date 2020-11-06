package com.zhouhao.study.maven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void sum() {
        Calculator calculator = new Calculator();

        assertEquals(100, calculator.sum(10, 20, 30, 40));
        assertEquals(0, calculator.sum());
    }
}