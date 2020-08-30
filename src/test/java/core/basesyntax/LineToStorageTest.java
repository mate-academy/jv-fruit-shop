package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LineToStorageTest {
    private static DataParser parser = new DataParser();
    private static StorageUpdaterImpl newUpdate;
    private Map<String, TreeMap<LocalDate, Integer>> toCompareStore;

    private static final Transaction SUPPLY_BANANA_TO_STORE
            = parser.parseLineToTransaction("s,banana,15,2020-10-17");
    private static final Transaction SUPPLY_ORANGE_TO_STORE
            = parser.parseLineToTransaction("s,orange,15,2020-10-19");
    private static final Transaction RETURN_ORANGE_TO_STORE
            = parser.parseLineToTransaction("r,orange,17,2020-10-21");
    private static final Transaction SUPPLY_ORANGE_WITH_SAME_EXPIRATION
            = parser.parseLineToTransaction("s,orange,10,2020-10-19");
    private static final Transaction SUPPLY_APPLE_TO_STORE
            = parser.parseLineToTransaction("s,apple,20,2020-10-22");
    private static final Transaction BUY_APPLE_MORE_THAN_IN_STOCK
            = parser.parseLineToTransaction("b,apple,30,2020-10-22");
    private static final Transaction RETURN_APPLE_WITH_SAME_EXPIRATION
            = parser.parseLineToTransaction("r,apple,14,2020-10-22");
    private static final Transaction BUY_BANANA_OVER_EXPIRATION_DATE
            = parser.parseLineToTransaction("b,banana,10,2020-10-18");
    private static final Transaction BUY_BANANA_LESS_THAN_IN_STOCK
            = parser.parseLineToTransaction("b,banana,10,2020-10-16");
    private static final Transaction RETURN_BANANA_TO_STORE
            = parser.parseLineToTransaction("r,banana,7,2020-10-20");
    private static final Transaction RETURN_ORANGE_OVER_PURCHASE_DATE
            = parser.parseLineToTransaction("r,orange,10,2020-10-18");
    private static final Transaction BUY_LOTS_OF_ORANGES
            = parser.parseLineToTransaction("b,orange,50,2020-10-19");

    @Before
    public void setUp() {
        newUpdate = new StorageUpdaterImpl();
        toCompareStore = new HashMap<>();
        Storage.clearStorage();
    }

    @Test
    public void buyWhenStockIsEmpty() {
        newUpdate.putLineToStorage(BUY_BANANA_OVER_EXPIRATION_DATE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void returnWhenStockIsEmpty() {
        toCompareStore.put("orange", new TreeMap<>());
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-21"), 17);
        newUpdate.putLineToStorage(RETURN_ORANGE_TO_STORE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void supplyWhenStockIsEmpty() {
        toCompareStore.put("apple", new TreeMap<>());
        toCompareStore.get("apple").put(LocalDate.parse("2020-10-22"), 20);
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyWhenExpirationDateOver() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 15);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(BUY_BANANA_OVER_EXPIRATION_DATE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyLessThanInStock() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 5);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(BUY_BANANA_LESS_THAN_IN_STOCK);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyMoreThanInStock() {
        toCompareStore.put("apple", new TreeMap<>());
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        newUpdate.putLineToStorage(BUY_APPLE_MORE_THAN_IN_STOCK);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void supplyAndReturnDifferentFruits() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.put("apple", new TreeMap<>());
        toCompareStore.put("orange", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 15);
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-19"), 15);
        toCompareStore.get("apple").put(LocalDate.parse("2020-10-22"), 20);
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-21"), 17);
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-20"), 7);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(SUPPLY_ORANGE_TO_STORE);
        newUpdate.putLineToStorage(RETURN_BANANA_TO_STORE);
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        newUpdate.putLineToStorage(RETURN_ORANGE_TO_STORE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void supplyAndReturnWithSameExpirationDate() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.put("apple", new TreeMap<>());
        toCompareStore.put("orange", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 15);
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-19"), 25);
        toCompareStore.get("apple").put(LocalDate.parse("2020-10-22"), 34);
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-20"), 7);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(SUPPLY_ORANGE_TO_STORE);
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        newUpdate.putLineToStorage(RETURN_APPLE_WITH_SAME_EXPIRATION);
        newUpdate.putLineToStorage(SUPPLY_ORANGE_WITH_SAME_EXPIRATION);
        newUpdate.putLineToStorage(RETURN_BANANA_TO_STORE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyFromFewExpirationDateInstances() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.put("apple", new TreeMap<>());
        toCompareStore.put("orange", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 15);
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-18"), 10);
        toCompareStore.get("apple").put(LocalDate.parse("2020-10-22"), 20);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(SUPPLY_ORANGE_TO_STORE);
        newUpdate.putLineToStorage(RETURN_ORANGE_TO_STORE);
        newUpdate.putLineToStorage(RETURN_ORANGE_OVER_PURCHASE_DATE);
        newUpdate.putLineToStorage(SUPPLY_ORANGE_WITH_SAME_EXPIRATION);
        newUpdate.putLineToStorage(BUY_LOTS_OF_ORANGES);
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        Map<String, TreeMap<LocalDate, Integer>> actualResult = Storage.getAllData();
        Assert.assertEquals(toCompareStore, actualResult);
    }
}
