/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import calculator.Calculator;

/**
 *
 * @author mguzmana
 */
public class CalculatorJUnitTest {
    
    /**
     * Empty Constructor
     */
    public CalculatorJUnitTest() {
    }
    
    /**
     * Test the Calculator
     */
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }
}
