package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import db.Storage;
import model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PurchaseOperationTest {
    private final PurchaseOperation purchaseOperation = new PurchaseOperation();

    @AfterEach
    void clearStorage() {
        Storage.storage.clear();
    }

    @Test
    void subtractQuantityInStorage_Ok() {
        Storage.storage.put("apple", 100);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 30);

        purchaseOperation.apply(fruitTransaction);

        assertEquals(70, Storage.storage.get("apple"));
    }

    @Test
    void negativeResultInStorage_notOk() {
        Storage.storage.put("apple", 100);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 150);
        assertThrows(RuntimeException.class, () -> purchaseOperation.apply(fruitTransaction));
    }

    @Test
    void nonExistingFruit_notOk() {
        Storage.storage.clear();
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "pineapple", 100);
        assertThrows(RuntimeException.class, () -> purchaseOperation.apply(fruitTransaction));
    }
}
