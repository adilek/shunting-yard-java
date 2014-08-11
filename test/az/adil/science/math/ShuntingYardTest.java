/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.adil.science.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author adil
 */
public class ShuntingYardTest {

    public ShuntingYardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of infixToPostfix method, of class ShuntingYard.
     */
    @Test
    public void testInfixToPostfix() {
        System.out.println("infixToPostfix");
        ShuntingYard instance = new ShuntingYard();
        List<String> expResult;

        expResult = new ArrayList<>();
        String[] array1 = {"3", "3", "*"};
        expResult.addAll(Arrays.asList(array1));
        assertEquals(expResult, instance.infixToPostfix("3*3"));

        expResult = new ArrayList<>();
        String[] array2 = {"2", "3", "8", "4", "-", "*", "+"};
        expResult.addAll(Arrays.asList(array2));
        assertEquals(expResult, instance.infixToPostfix("2+(3*(8-4))"));

        expResult = new ArrayList<>();
        String[] array3 = {"3", "3", "*", "3", "*", "3", "*", "3", "*", "3", "*"};
        expResult.addAll(Arrays.asList(array3));
        assertEquals(expResult, instance.infixToPostfix("3*3*3*3*3*3"));

        expResult = new ArrayList<>();
        String[] array4 = {"1", "2", "+", "3", "/", "4", "^"};
        expResult.addAll(Arrays.asList(array4));
        assertEquals(expResult, instance.infixToPostfix("((1+2)/3)^4"));

        expResult = new ArrayList<>();
        String[] array5 = {"1", "2", "+", "3", "4", "/", "5", "6", "+", "^", "*"};
        expResult.addAll(Arrays.asList(array5));
        assertEquals(expResult, instance.infixToPostfix("(1+2)*(3/4)^(5+6)"));

        expResult = new ArrayList<>();
        String[] array6 = {"3", "4", "5", "*", "6", "/", "+"};
        expResult.addAll(Arrays.asList(array6));
        assertEquals(expResult, instance.infixToPostfix("3+4*5/6"));

        expResult = new ArrayList<>();
        String[] array7 = {"300", "23", "+", "43", "21", "-", "*", "84", "7", "+", "/"};
        expResult.addAll(Arrays.asList(array7));
        assertEquals(expResult, instance.infixToPostfix("(300+23)*(43-21)/(84+7)"));

        expResult = new ArrayList<>();
        String[] array8 = {"4", "8", "+", "6", "5", "-", "*", "3", "2", "-", "2", "2", "+", "*", "/"};
        expResult.addAll(Arrays.asList(array8));
        assertEquals(expResult, instance.infixToPostfix("(4+8)*(6-5)/((3-2)*(2+2))"));

        expResult = new ArrayList<>();
        String[] array9 = {"4444", "222", "1111", "+", "1111", "*", "2", "+", "2222", "*", "44444", "*", "2", "+", "*", "333", "333", "+", "2", "*", "*"};
        expResult.addAll(Arrays.asList(array9));
        assertEquals(expResult, instance.infixToPostfix("4444*(((222+1111)*1111+2)*2222*44444+2)*((333+333)*2)"));

    }

    /**
     * Test of operatorPriority method, of class ShuntingYard.
     */
    @Test
    public void testOperatorPriority() {
        System.out.println("operatorPriority");
        char operator = ' ';
        ShuntingYard instance = new ShuntingYard();

        assertEquals(1, instance.operatorPriority('+'));
        assertEquals(1, instance.operatorPriority('-'));
        assertEquals(2, instance.operatorPriority('*'));
        assertEquals(2, instance.operatorPriority('/'));
        assertEquals(3, instance.operatorPriority('^'));

    }

    /**
     * Test of isInteger method, of class ShuntingYard.
     */
    @Test
    public void testIsInteger() {
        System.out.println("isInteger");
        String number = "";
        ShuntingYard instance = new ShuntingYard();

        assertTrue(instance.isInteger("3234235"));
        assertTrue(instance.isInteger("00000"));
        assertTrue(instance.isInteger("999999999"));
        assertFalse(instance.isInteger("323f4235"));
        assertFalse(instance.isInteger("323f4235-"));
        assertFalse(instance.isInteger("3AA"));

    }

    /**
     * Test of evaluatePostfix method, of class ShuntingYard.
     */
    @Test
    public void testEvaluatePostfix() {
        System.out.println("evaluatePostfix");
        ShuntingYard instance = new ShuntingYard();
        List<String> expResult;
        double delta = 0.01;

        String[] array1 = {"3", "3", "*"};
        assertEquals(9.0, instance.evaluatePostfix(Arrays.asList(array1)),delta);

        String[] array2 = {"2", "3", "8", "4", "-", "*", "+"};
        assertEquals(14.0, instance.evaluatePostfix(Arrays.asList(array2)),delta);

        String[] array3 = {"3", "3", "*", "3", "*", "3", "*", "3", "*", "3", "*"};
        assertEquals(729.0, instance.evaluatePostfix(Arrays.asList(array3)),delta);

        String[] array4 = {"1", "2", "+", "3", "/", "4", "^"};
        assertEquals(1.0, instance.evaluatePostfix(Arrays.asList(array4)),delta);

        String[] array5 = {"1", "2", "+", "3", "4", "/", "5", "6", "+", "^", "*"};
        assertEquals(0.126705408, instance.evaluatePostfix(Arrays.asList(array5)),delta);

        String[] array6 = {"3", "4", "5", "*", "6", "/", "+"};
        assertEquals(6.333333333, instance.evaluatePostfix(Arrays.asList(array6)),delta);

        String[] array7 = {"300", "23", "+", "43", "21", "-", "*", "84", "7", "+", "/"};
        assertEquals(78.087912088, instance.evaluatePostfix(Arrays.asList(array7)),delta);

        String[] array8 = {"4", "8", "+", "6", "5", "-", "*", "3", "2", "-", "2", "2", "+", "*", "/"};
        assertEquals(3.0, instance.evaluatePostfix(Arrays.asList(array8)),delta);

    }

    

}
