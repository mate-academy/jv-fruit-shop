package core.basesyntax.fruitoperation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OperationsTest {
    @Test
    public void test_contains_Ok() {
        assertTrue(Operations.contains("P"));
        assertTrue(Operations.contains("p"));
        assertFalse(Operations.contains("G"));
    }
}
