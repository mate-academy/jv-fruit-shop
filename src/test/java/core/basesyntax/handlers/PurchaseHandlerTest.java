package core.basesyntax.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PurchaseHandlerTest {
    private static Activity activity;
    private static final int NEGATIVE_COUNT_OF_STORAGE = -5;
    private static final int NEGATIVE_CURRENT_COUNT = -15;
    private static final int POSITIVE_CURRENT_COUNT = 15;
    private static final int POSITIVE_COUNT_OF_STORAGE = 5;
    private static final int POSITIVE_COUNT_OF_STORAGE_NOT_OK = 25;

    @BeforeAll
    static void beforeAll() {
        activity = new PurchaseHandler();
    }

    @Test
    void calculateCountWithTwoPositiveOperands_Ok() {
        int expected = 10;
        int actual = activity.calculateCount(POSITIVE_CURRENT_COUNT,
                POSITIVE_COUNT_OF_STORAGE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateCountWithPositiveOperands_NotOK() {
        assertThrows(RuntimeException.class,
                () -> activity.calculateCount(POSITIVE_CURRENT_COUNT,
                        POSITIVE_COUNT_OF_STORAGE_NOT_OK));
    }

    @Test
    void calculateCountWithPositiveAndNegativeOperands_Ok() {
        int expected = 20;
        int actual = activity.calculateCount(POSITIVE_CURRENT_COUNT,
                NEGATIVE_COUNT_OF_STORAGE);
        assertEquals(expected, actual);
    }

    @Test
    void calculateCountWithNegativeAndPositiveOperands_NotOk() {
        assertThrows(RuntimeException.class,
                () -> activity.calculateCount(NEGATIVE_CURRENT_COUNT,
                        POSITIVE_COUNT_OF_STORAGE));
    }
}
