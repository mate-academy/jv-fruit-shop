package core.activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReturnActivitiesHandlerTest {
    private static ActivitiesHandler returnActivityHandler;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %d But was: %d";

    @BeforeAll
    public static void beforeAll() {
        returnActivityHandler = new ReturnActivitiesHandler();
    }

    @Test
    public void testForCorrectInputData() {
        int firstExpected = 60;
        int secondExpected = 205;
        int firstActual = returnActivityHandler.getAmountOfFruits(45, 15);
        int secondActual = returnActivityHandler.getAmountOfFruits(150, 55);
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class, () -> returnActivityHandler
                .getAmountOfFruits(0, -20));
        assertThrows(RuntimeException.class, () -> returnActivityHandler
                .getAmountOfFruits(100, -150));
    }
}
