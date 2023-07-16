package db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitStorageTest {
    private FruitStorage storage;
    private Map<String,Integer> expectedFruitStock;

    @BeforeEach
    void setUp() {
        storage = new FruitStorage();
        expectedFruitStock = new HashMap<>();

        storage.setFruit("banana", 100);
        storage.setFruit("apple", 25);
    }

    @Test
    void getFruitFromStock_ok() {
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 25);
        Map<String,Integer> actualFruitStock = storage.getFruitStock();
        assertEquals(expectedFruitStock, actualFruitStock,
                "Actual and expected fruit stocks must be equals");
    }

    @Test
    void getInvalidFruitType_notOk() {
        assertThrows(RuntimeException.class, () -> storage.getFruit("orange"),
                "There is no such fruit type in storage");
    }

    @Test
    void setFruitToStock_ok() {
        expectedFruitStock.put("banana", 125);
        expectedFruitStock.put("apple", 100);
        storage.setFruit("banana", 125);
        storage.setFruit("apple", 100);

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual storage and expected storage must be equals");
    }

    @Test
    void addFruitsToStock_ok() {
        expectedFruitStock.put("banana", 110);
        expectedFruitStock.put("apple", 35);

        storage.addFruitsToStock("banana", 10);
        storage.addFruitsToStock("apple", 10);

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void addNewTypeOfFruit_ok() {
        expectedFruitStock.put("orange", 30);
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 25);
        storage.addFruitsToStock("orange", 30);

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void addNegativeFruitQuantity_notOk() {
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 25);
        assertThrows(RuntimeException.class, () -> storage.addFruitsToStock("banana", -10),
                "Can't add fruit to storage, fruit q-ty can't be less than zero");

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals, should not add negative q-ty");
    }

    @Test
    void removeFruitFromStock_ok() {
        expectedFruitStock.put("banana", 100);

        storage.removeFruitsFromStock("apple", storage.getFruit("apple").getQuantity());

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void removeFruitPartiallyFromStock_ok() {
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 10);

        storage.removeFruitsFromStock("apple", 15);

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @Test
    void removeNonexistentFruitFromStock_ok() {
        String fruit = "orange";
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 25);

        assertThrows(RuntimeException.class, () -> storage.removeFruitsFromStock(fruit, 10),
                "There is no such fruit type [" + fruit + "]");

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equal");
    }

    @Test
    void getFruitStock() {
        expectedFruitStock.put("banana", 100);
        expectedFruitStock.put("apple", 25);

        assertEquals(expectedFruitStock, storage.getFruitStock(),
                "Actual and expected storages must be equals");
    }

    @AfterEach
    void tearDown() {
        expectedFruitStock.clear();
    }
}
