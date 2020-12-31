package core.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BalanceActivitiesHandlerTest {
    private static ActivitiesHandler balanceActivityHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        balanceActivityHandler = new BalanceActivitiesHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 15;
        int secondExpected = 65;
        int firstActual = balanceActivityHandler.getAmountOfFruits(0, 15);
        int secondActual = balanceActivityHandler.getAmountOfFruits(30, 35);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class, () -> balanceActivityHandler
                .getAmountOfFruits(0, -20));
    }
}
