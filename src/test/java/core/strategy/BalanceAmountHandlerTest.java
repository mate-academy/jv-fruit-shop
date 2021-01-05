package core.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BalanceAmountHandlerTest {
    private static AmountHandler balanceAmountHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        balanceAmountHandler = new BalanceAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 15;
        int secondExpected = 65;
        int firstActual = balanceAmountHandler.calculateAmount(0, 15);
        int secondActual = balanceAmountHandler.calculateAmount(30, 35);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }
}