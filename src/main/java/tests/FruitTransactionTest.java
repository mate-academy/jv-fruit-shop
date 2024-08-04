package tests;

import core.basesyntax.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FruitTransactionTest {
    @Test
    public void testFruitTransaction() {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        assertEquals(Operation.BALANCE, transaction.getOperation());
        assertEquals("banana", transaction.getFruit());
        assertEquals(100, transaction.getQuantity());
    }
}


