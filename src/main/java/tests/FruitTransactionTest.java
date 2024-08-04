package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;

import org.junit.jupiter.api.Test;

public class FruitTransactionTest {

    @Test
    public void testSetAndGetOperation() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);

        assertEquals(Operation.BALANCE, transaction.getOperation(), "Operation should be BALANCE");
    }

    @Test
    public void testSetAndGetFruit() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setFruit("banana");

        assertEquals("banana", transaction.getFruit(), "Fruit should be banana");
    }

    @Test
    public void testSetAndGetQuantity() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setQuantity(100);

        assertEquals(100, transaction.getQuantity(), "Quantity should be 100");
    }
}
