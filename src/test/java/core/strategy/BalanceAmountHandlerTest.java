package core.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BalanceAmountHandlerTest {
    private static AmountHandler balanceAmountHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @Before
    public void beforeAll() {
        balanceAmountHandler = new BalanceAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 15;
        int secondExpected = 65;
        int firstActual = balanceAmountHandler.calculateAmount(0, 15);
        int secondActual = balanceAmountHandler.calculateAmount(30, 35);
        assertEquals(firstExpected, firstActual);
        assertEquals(secondExpected, secondActual);
    }
}
