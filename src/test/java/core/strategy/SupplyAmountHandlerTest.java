package core.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SupplyAmountHandlerTest {
    private static AmountHandler supplyAmountHandler;

    @Before
    public void beforeAll() {
        supplyAmountHandler = new SupplyAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 60;
        int secondExpected = 205;
        int firstActual = supplyAmountHandler.calculateAmount(45, 15);
        int secondActual = supplyAmountHandler.calculateAmount(150, 55);
        assertEquals(firstExpected, firstActual);
        assertEquals(firstExpected, firstActual);
    }
}
