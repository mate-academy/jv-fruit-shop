package core.basesyntax.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SupplyHandlerTest {
    private static Activity activity;
    private static final int POSITIVE_CURRENT_COUNT = 10;
    private static final int NEGATIVE_CURRENT_COUNT = -15;
    private static final int POSITIVE_COUNT_OF_STORAGE = 5;
    private static final int NEGATIVE_COUNT_OF_STORAGE = -10;

    @BeforeAll
    static void beforeAll() {
        activity = new SupplyHandler();
    }

    @Test
    void calculateCountWithTwoPositiveOperands_Ok() {
        int expected = 15;
        int actual = activity.calculateCount(POSITIVE_CURRENT_COUNT,
                POSITIVE_COUNT_OF_STORAGE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateCountWithTwoNegativeOperands_Ok() {
        int expected = -25;
        int actual = activity.calculateCount(NEGATIVE_CURRENT_COUNT,
                NEGATIVE_COUNT_OF_STORAGE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateCountWithPositiveAndNegativeOperands_Ok() {
        int expected = 0;
        int actual = activity.calculateCount(POSITIVE_CURRENT_COUNT,
                NEGATIVE_COUNT_OF_STORAGE);
        assertEquals(expected, actual);
    }
}
