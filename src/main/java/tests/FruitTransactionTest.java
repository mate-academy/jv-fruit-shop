package tests;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FruitTransactionTest {

    @Test
    public void test_set_and_get_operation() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);

        assertEquals(Operation.BALANCE, transaction.getOperation(), "Operation should be BALANCE");
    }

    @Test
    public void test_set_and_get_fruit() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setFruit("banana");

        assertEquals("banana", transaction.getFruit(), "Fruit should be banana");
    }

    @Test
    public void test_set_and_get_quantity() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setQuantity(100);

        assertEquals(100, transaction.getQuantity(), "Quantity should be 100");
    }
}
