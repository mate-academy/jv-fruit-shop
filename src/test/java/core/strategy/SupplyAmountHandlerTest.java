package core.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SupplyAmountHandlerTest {
    private static AmountHandler supplyAmountHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        supplyAmountHandler = new SupplyAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 60;
        int secondExpected = 205;
        int firstActual = supplyAmountHandler.calculateAmount(45, 15);
        int secondActual = supplyAmountHandler.calculateAmount(150, 55);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }
}