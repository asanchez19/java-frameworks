/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.test;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mguzmana
 */
public class Exception1Test {
    
    public Exception1Test() {
    }
    
    @Before
    public void setUp() {
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        new ArrayList<>().get(0);
    }
}
