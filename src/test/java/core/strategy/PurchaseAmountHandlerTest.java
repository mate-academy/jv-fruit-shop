package core.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PurchaseAmountHandlerTest {
    private static AmountHandler purchaseAmountHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        purchaseAmountHandler = new PurchaseAmountHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 30;
        int secondExpected = 95;
        int firstActual = purchaseAmountHandler.calculateAmount(45, 15);
        int secondActual = purchaseAmountHandler.calculateAmount(150, 55);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectData() {
        assertThrows(RuntimeException.class, () -> purchaseAmountHandler
                .calculateAmount(0, 20));
        assertThrows(RuntimeException.class, () -> purchaseAmountHandler
                .calculateAmount(100, 150));
    }
}