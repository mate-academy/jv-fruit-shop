package core.basesyntax.fruitoperation;

import junit.framework.TestCase;

public class OperationsTest extends TestCase {
    public void test_contains_Ok() {
        assertTrue(Operations.contains("P"));
        assertFalse(Operations.contains("G"));
    }
}