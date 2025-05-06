package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import db.Storage;
import model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ReturnOperationTest {
    private final ReturnOperation returnOperation = new ReturnOperation();

    @AfterEach
    void clearStorage() {
        Storage.storage.clear();
    }

    @Test
    void returnToExistingFruit_ok() {
        Storage.storage.put("apple", 50);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 50);

        returnOperation.apply(fruitTransaction);

        assertEquals(100, Storage.storage.get("apple"));
    }

    @Test
    void returnNonExistingFruit_notOk() {
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "pineapple", 50);

        returnOperation.apply(fruitTransaction);

        assertEquals(50, Storage.storage.get("pineapple"));
    }

    @Test
    void returnZeroQuantity_noChangeStorage() {
        Storage.storage.put("apple", 50);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "apple", 0);

        returnOperation.apply(fruitTransaction);

        assertEquals(50, Storage.storage.get("apple"));
    }
}
