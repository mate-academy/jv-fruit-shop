package core.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PurchaseAmountHandlerTest {
    private static AmountHandler purchaseAmountHandler;

    @Before
    public void beforeAll() {
        purchaseAmountHandler = new PurchaseAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 30;
        int secondExpected = 95;
        int firstActual = purchaseAmountHandler.calculateAmount(45, 15);
        int secondActual = purchaseAmountHandler.calculateAmount(150, 55);
        assertEquals(firstExpected, firstActual);
        assertEquals(secondExpected, secondActual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectData() {
        purchaseAmountHandler.calculateAmount(0, 20);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataSecond() {
        purchaseAmountHandler.calculateAmount(100, 150);
    }
}
