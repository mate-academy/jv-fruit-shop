package core.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OperationsTest {
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";
    @Test
    public void testForCorrectInput() {
        Operations firstExpected = Operations.BALANCE;
        Operations secondExpected = Operations.PURCHASE;
        Operations thirdExpected = Operations.RETURN;
        Operations firstActual = Operations.operationFromString("b");
        Operations secondActual = Operations.operationFromString("p");
        Operations thirdActual = Operations.operationFromString("r");
        assertEquals(firstExpected, firstActual, String.format(STRING_FORMAT_FOR_WRONG,
                firstExpected, firstActual));
        assertEquals(secondExpected, secondActual, String.format(STRING_FORMAT_FOR_WRONG,
                secondActual, secondActual));
        assertEquals(thirdExpected, thirdActual, String.format(STRING_FORMAT_FOR_WRONG,
                thirdExpected, thirdActual));
    }

    @Test
    public void testForIncorrectData() {
        assertThrows(RuntimeException.class, () -> Operations.operationFromString("d"));
        assertThrows(RuntimeException.class, () -> Operations.operationFromString(""));
        assertThrows(RuntimeException.class, () -> Operations.operationFromString("$"));
    }
}