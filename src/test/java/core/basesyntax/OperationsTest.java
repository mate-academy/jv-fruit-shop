package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.SupplyOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperationsTest {
    private static Storage storage;

    @Before
    public void clearStorage() {
        storage = new Storage();
    }

    @Test
    public void supplyOperationOkTest() {
        Transaction transaction = new Transaction("s", "banana", 100,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        SupplyOperation supply = new SupplyOperation(storage);
        supply.performOperation(transaction);

        Assert.assertEquals(storage.getStorage().size(), 100);
    }

    @Test
    public void buyOperationOkTest() {
        for (int i = 0; i < 20; i++) {
            storage.addFruit(new Fruit("banana",
                    LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        Transaction transaction = new Transaction("b", "banana", 17,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        BuyOperation buy = new BuyOperation(storage);
        buy.performOperation(transaction);

        Assert.assertEquals(storage.getStorage().size(), 3);
    }

    @Test (expected = RuntimeException.class)
    public void buyOperationNotEnoughFruitsTest() {
        for (int i = 0; i < 15; i++) {
            storage.addFruit(new Fruit("banana",
                    LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        Transaction transaction = new Transaction("b", "banana", 17,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        BuyOperation buy = new BuyOperation(storage);
        buy.performOperation(transaction);
    }

    @Test (expected = RuntimeException.class)
    public void buyOperationNotFreshFruitsTest() {
        for (int i = 0; i < 20; i++) {
            storage.addFruit(new Fruit("banana",
                    LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        Transaction transaction = new Transaction("b", "banana", 17,
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
        BuyOperation buy = new BuyOperation(storage);
        buy.performOperation(transaction);
    }
}
