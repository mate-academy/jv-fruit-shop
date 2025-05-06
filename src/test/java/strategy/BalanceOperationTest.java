package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import db.Storage;
import model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class BalanceOperationTest {
    private final BalanceOperation balanceOperation = new BalanceOperation();

    @AfterEach
    void clearStorage() {
        Storage.storage.clear();
    }

    @Test
    void correctQuantityInStorage_Ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 100);
        balanceOperation.apply(fruitTransaction);

        assertEquals(100, Storage.storage.get("apple"));
    }

    @Test
    void overWriting_AdditionToStorage_Ok() {
        Storage.storage.put("apple", 100);

        FruitTransaction fruitTransaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE, "apple", 200);
        balanceOperation.apply(fruitTransaction);

        assertEquals(200, Storage.storage.get("apple"));
    }
}
