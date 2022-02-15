package core.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReturnAmountHandlerTest {
    private static AmountHandler returnAmountHandler;

    @Before
    public void beforeAll() {
        returnAmountHandler = new ReturnAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 60;
        int secondExpected = 205;
        int firstActual = returnAmountHandler.calculateAmount(45, 15);
        int secondActual = returnAmountHandler.calculateAmount(150, 55);
        assertEquals(firstExpected, firstActual);
        assertEquals(firstExpected, firstActual);
    }
}
