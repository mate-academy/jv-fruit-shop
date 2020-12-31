package core.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SupplyActivitiesHandlerTest {
    private static ActivitiesHandler supplyActivityHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        supplyActivityHandler = new SupplyActivitiesHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 60;
        int secondExpected = 205;
        int firstActual = supplyActivityHandler.getAmountOfFruits(45, 15);
        int secondActual = supplyActivityHandler.getAmountOfFruits(150, 55);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class, () -> supplyActivityHandler
                .getAmountOfFruits(0, -20));
        assertThrows(RuntimeException.class, () -> supplyActivityHandler
                .getAmountOfFruits(100, -150));
    }
}
