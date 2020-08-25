package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;
import java.util.*;

public class LineToStorageTest {
    private static UpdateStorage newUpdate;
    private HashMap<String, TreeMap<LocalDate, Integer>> toCompareStore;
    private static final List<String> SUPPLY_BANANA_TO_STORE
            = new ArrayList<>(List.of("s", "banana", "15", "2020-10-17"));
    private static final List<String> SUPPLY_ORANGE_TO_STORE
            = new ArrayList<>(List.of("s", "orange", "15", "2020-10-19"));
    private static final List<String> RETURN_ORANGE_TO_STORE
            = new ArrayList<>(List.of("r", "orange", "17", "2020-10-21"));
    private static final List<String> SUPPLY_ORANGE_WITH_SAME_EXPIRATION
            = new ArrayList<>(List.of("s", "orange", "10", "2020-10-19"));
    private static final List<String> SUPPLY_APPLE_TO_STORE
            = new ArrayList<>(List.of("s", "apple", "20", "2020-10-22"));
    private static final List<String> BUY_APPLE_MORE_THAN_IN_STOCK
            = new ArrayList<>(List.of("b", "apple", "30", "2020-10-22"));
    private static final List<String> RETURN_APPLE_WITH_SAME_EXPIRATION
            = new ArrayList<>(List.of("r", "apple", "14", "2020-10-22"));
    private static final List<String> BUY_BANANA_OVER_EXPIRATION_DATE
            = new ArrayList<>(List.of("b", "banana", "10", "2020-10-18"));
    private static final List<String> BUY_BANANA_LESS_THAN_IN_STOCK
            = new ArrayList<>(List.of("b", "banana", "10", "2020-10-16"));
    private static final List<String> RETURN_BANANA_TO_STORE
            = new ArrayList<>(List.of("r", "banana", "7", "2020-10-20"));
    private static final List<String> RETURN_ORANGE_OVER_PURCHASE_DATE
            = new ArrayList<>(List.of("r", "orange", "10", "2020-10-18"));
    private static final List<String> BUY_LOTS_OF_ORANGES
            = new ArrayList<>(List.of("b", "orange", "50", "2020-10-19"));

    @Before
    public void setUp() {
        newUpdate = new UpdateStorageImpl();
        toCompareStore = new HashMap<>();
        Storage.fruitsInStore = new HashMap<>();
    }

    @Test
    public void buyWhenStockIsEmpty() {
        newUpdate.putLineToStorage(BUY_BANANA_OVER_EXPIRATION_DATE);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void returnWhenStockIsEmpty() {
        toCompareStore.put("orange", new TreeMap<>());
        toCompareStore.get("orange").put(LocalDate.parse("2020-10-21"), 17);
        newUpdate.putLineToStorage(RETURN_ORANGE_TO_STORE);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void supplyWhenStockIsEmpty() {
        toCompareStore.put("apple", new TreeMap<>());
        toCompareStore.get("apple").put(LocalDate.parse("2020-10-22"), 20);
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyWhenExpirationDateOver() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 15);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(BUY_BANANA_OVER_EXPIRATION_DATE);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyLessThanInStock() {
        toCompareStore.put("banana", new TreeMap<>());
        toCompareStore.get("banana").put(LocalDate.parse("2020-10-17"), 5);
        newUpdate.putLineToStorage(SUPPLY_BANANA_TO_STORE);
        newUpdate.putLineToStorage(BUY_BANANA_LESS_THAN_IN_STOCK);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }

    @Test
    public void buyMoreThanInStock() {
        toCompareStore.put("apple", new TreeMap<>());
        newUpdate.putLineToStorage(SUPPLY_APPLE_TO_STORE);
        newUpdate.putLineToStorage(BUY_APPLE_MORE_THAN_IN_STOCK);
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
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
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
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
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
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
        HashMap<String, TreeMap<LocalDate, Integer>> actualResult = Storage.fruitsInStore;
        Assert.assertEquals(toCompareStore, actualResult);
    }
}
