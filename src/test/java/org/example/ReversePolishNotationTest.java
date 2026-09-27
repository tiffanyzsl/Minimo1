package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReversePolishNotationTest {

    private ReversePolishNotation rpn;

    @Before
    public void setUp() {
        this.rpn = new ReversePolishNotationImpl();
    }

    @Test
    public void testEjemploEnunciado() {
        // 5 + ((1 + 2) * 4) - 3 = 14
        String expresion = "5 1 2 + 4 * + 3 -";
        double resultado = rpn.process(expresion);
        Assert.assertEquals(14.0, resultado, 0.001);
    }
}
