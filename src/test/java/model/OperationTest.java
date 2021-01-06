package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationTest {
    private static final String INVALID_OPERATION = "?";
    private static final String VALID_OPERATION = "b";
    private static final Operation OPERATION = Operation.RETURN;

    @Test
    public void testGetOperation_Ok() {
        assertEquals(OPERATION.getOperation(), "r");
    }

    @Test
    public void testGetValidOperationFromString_Ok() {
        assertEquals(Operation.BALANCE, Operation.fromString(VALID_OPERATION));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOperation_Ok() {
        Operation.fromString(INVALID_OPERATION);
    }
}
