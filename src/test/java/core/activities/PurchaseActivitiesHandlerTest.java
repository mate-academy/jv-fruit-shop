package core.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PurchaseActivitiesHandlerTest {
    private static ActivitiesHandler purchaseActivityHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        purchaseActivityHandler = new PurchaseActivitiesHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 30;
        int secondExpected = 95;
        int firstActual = purchaseActivityHandler.getAmountOfFruits(45, 15);
        int secondActual = purchaseActivityHandler.getAmountOfFruits(150, 55);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class, () -> purchaseActivityHandler
                .getAmountOfFruits(0, -20));
        assertThrows(RuntimeException.class, () -> purchaseActivityHandler
                .getAmountOfFruits(0, 20));
        assertThrows(RuntimeException.class, () -> purchaseActivityHandler
                .getAmountOfFruits(100, 150));
    }
}
