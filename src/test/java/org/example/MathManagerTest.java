package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class MathManagerTest {

    private MathManager manager;

    @Before
    public void setUp() {
        this.manager = MathManagerImpl.getInstance();
    }

    @Test
    public void testFlujoCompleto() {
        manager.requerirOperacion("alumno1", "insLesseps", "5 1 2 + 4 * + 3 -");
        Operacion op1 = manager.procesarOperacion();
        Assert.assertNotNull(op1);
        Assert.assertEquals(14.0, op1.getResultado(), 0.001);
    }
}