package core.basesyntax.shop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ActivitiesTest {
    private static final String ACTIVITY = "B";
    private static final String ACTIVITY_NOT_OK = "X";

    @Test
    void checkIsValidActivities_OK() {
        boolean actual = Activities.isValid(ACTIVITY);
        assertTrue(actual);
    }

    @Test
    void checkIsValidActivities_NotOK() {
        boolean actual = Activities.isValid(ACTIVITY_NOT_OK);
        assertFalse(actual);
    }
}
