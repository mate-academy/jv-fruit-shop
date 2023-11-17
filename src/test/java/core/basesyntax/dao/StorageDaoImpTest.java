package core.basesyntax.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.InMemoryStorage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageDaoImpTest {

    private final StorageDao storageDao = new StorageDaoImpl();

    @AfterAll
    public static void clearStorageAfterTest() {
        InMemoryStorage.items.clear();
    }

    @BeforeEach
    public void clearStorage() {
        InMemoryStorage.items.clear();
    }

    @Test
    void balance() {
        storageDao.balance(new Item("banana", 10));
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 10);
        assertEquals(expected, InMemoryStorage.items);
    }

    @Test
    void purchase() {
        storageDao.purchase(new Item("banana", 10));
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", -10);
        assertEquals(expected, InMemoryStorage.items);
    }

    @Test
    void returnItem() {
        storageDao.returnItem(new Item("banana", 10));
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 10);
        assertEquals(expected, InMemoryStorage.items);
    }

    @Test
    void supply() {
        storageDao.supply(new Item("banana", 10));
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 10);
        assertEquals(expected, InMemoryStorage.items);
    }

    @Test
    void allTest_NullItem() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put(null, 0);
        storageDao.balance(new Item(null, 0));
        assertEquals(expected, InMemoryStorage.items);
        storageDao.purchase(new Item(null, 0));
        assertEquals(expected, InMemoryStorage.items);
        storageDao.supply(new Item(null, 0));
        assertEquals(expected, InMemoryStorage.items);
        storageDao.returnItem(new Item(null, 0));
        assertEquals(expected, InMemoryStorage.items);
    }
}
