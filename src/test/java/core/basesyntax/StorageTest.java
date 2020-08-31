package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.StoreOperation;
import core.basesyntax.operations.SupplyOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageTest {
    private static Storage storage;
    private static Transaction transaction1 = new Transaction("s", "banana", 100,
            LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
    private static Transaction transaction2 = new Transaction("b", "banana", 17,
            LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
    private static Transaction transaction3 = new Transaction("r", "banana", 10,
            LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
    private static Transaction transaction4 = new Transaction("s", "orange", 50,
            LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));

    @Before
    public void prepareStorage() {
        storage = new Storage();
    }

    @Test
    public void getFruitsQuantityTest() {
        Map<String, Integer> expectedFruitsQuantity = new HashMap<>();
        expectedFruitsQuantity.put("banana", 93);
        expectedFruitsQuantity.put("orange", 50);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        Map<String, StoreOperation> storeOperationMap = new HashMap<>();
        storeOperationMap.put("s", new SupplyOperation(storage));
        storeOperationMap.put("b", new BuyOperation(storage));
        storeOperationMap.put("r", new ReturnOperation(storage));

        for (Transaction transaction : transactions) {
            storeOperationMap.get(transaction.getOperation()).performOperation(transaction);
        }

        Assert.assertEquals(storage.getFruitsQuantityByType(), expectedFruitsQuantity);
    }

    @Test
    public void fillStorageOkTest() {
        Storage expectedStorage = new Storage();
        for(int i = 0; i < 83; i++) {
            expectedStorage.addFruit(new Fruit("banana",
                    LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        }
        for(int i = 0; i < 50; i++) {
            expectedStorage.addFruit(new Fruit("orange",
                    LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE)));
        }

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction4);
        storage.fillStorage(transactions);
        Assert.assertEquals(expectedStorage, storage);
    }

    @Test
    public void StorageEqualsOkTest() {
        Storage expectedStorage = new Storage();
        expectedStorage.addFruit(new Fruit("banana",
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        storage.addFruit(new Fruit("banana",
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        Assert.assertTrue(expectedStorage.equals(storage));
    }

    @Test
    public void StorageHashCodeOkTest() {
        Storage expectedStorage = new Storage();
        expectedStorage.addFruit(new Fruit("banana",
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        storage.addFruit(new Fruit("banana",
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE)));
        Assert.assertEquals(expectedStorage.hashCode(), storage.hashCode());
    }
}
