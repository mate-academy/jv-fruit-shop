package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import db.Storage;
import model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SupplyOperationTest {
    private final SupplyOperation supplyOperation = new SupplyOperation();

    @AfterEach
    void tearDown() {
        Storage.storage.clear();
    }

    @Test
    void additionQuantityFruit_Ok() {
        Storage.storage.put("apple", 50);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 50);

        supplyOperation.apply(fruitTransaction);

        assertEquals(100, Storage.storage.get("apple"));
    }

    @Test
    void additionQuantityNewFruit_Ok() {
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "pineapple", 100);

        supplyOperation.apply(fruitTransaction);

        assertEquals(100, Storage.storage.get("pineapple"));
    }

    @Test
    void supplyZeroQuantity_noChangeStorage() {
        Storage.storage.put("apple", 50);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 0);

        supplyOperation.apply(fruitTransaction);

        assertEquals(50, Storage.storage.get("apple"));
    }
}
