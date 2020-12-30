package core.basesyntax.fruitoperation;

import junit.framework.TestCase;
import org.junit.Test;

public class OperationsTest extends TestCase {
    @Test
    public void test_contains_Ok() {
        assertTrue(Operations.contains("P"));
        assertFalse(Operations.contains("G"));
    }
}
