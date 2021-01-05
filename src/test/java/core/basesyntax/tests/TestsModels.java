package core.basesyntax.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import org.junit.Test;

public class TestsModels {
    private static TransactionDto transaction;
    private static Operation operation;
    private static Fruit fruit;

    @Test
    public void checkValidValues() {
        operation = Operation.BALANCE;
        fruit = new Fruit("banana");
        transaction = new TransactionDto(operation, fruit, 100);
        assertEquals(Operation.BALANCE, transaction.getOperation(),
                "Operation must be equal");
        assertEquals(new Fruit("banana"), transaction.getFruit(),
                "Fruits must be equal");
        assertEquals(100, transaction.getQuantity(),
                "values must be equal");
    }

    @Test(expected = RuntimeException.class)
    public void checkNotValidFruitNull() {
        new Fruit(null);
    }

    @Test(expected = RuntimeException.class)
    public void checkNotValidFruitLowLength() {
        new Fruit("ap");
    }

    @Test(expected = RuntimeException.class)
    public void checkNotValidQuantity() {
        operation = Operation.PURCHASE;
        transaction = new TransactionDto(operation, new Fruit("apple"),
                -10);
    }
}
