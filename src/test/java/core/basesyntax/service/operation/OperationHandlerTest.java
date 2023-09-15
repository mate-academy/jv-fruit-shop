package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.impl.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationHandlerTest {
    private final StorageDao storageDao = new StorageDaoImpl();
    private final OperationHandler balance = new BalanceHandler(storageDao);
    private final OperationHandler purchase = new PurchaseHandler(storageDao);
    private final OperationHandler returnOp = new ReturnHandler(storageDao);
    private final OperationHandler supply = new SupplyHandler(storageDao);
    private final FruitTransaction fruit1 = new FruitTransaction(FruitTransaction
            .Operation.BALANCE, "banana", 20);
    private final FruitTransaction fruit3 = new FruitTransaction(FruitTransaction
            .Operation.SUPPLY, "banana", 100);
    private final FruitTransaction fruit4 = new FruitTransaction(FruitTransaction
            .Operation.PURCHASE, "banana", 13);
    private final FruitTransaction fruit5 = new FruitTransaction(FruitTransaction
            .Operation.RETURN, "banana", 13);
    private final Map<String, Integer> storage = Storage.getFruits();

    @BeforeEach
    void beforeEach() {
        storage.clear();
    }

    @Test
    void putTransactionBalance_Ok() {
        balance.putTransaction(fruit1);
        Assertions.assertTrue(storage.containsKey("banana")
                && storage.get("banana").equals(20));
    }

    @Test
    void putTransactionBalance_transactionExist_Ok() {
        balance.putTransaction(fruit1);
        balance.putTransaction(fruit1);
        Assertions.assertTrue(storage.containsKey("banana")
                && storage.get("banana").equals(20));
    }

    @Test
    void putTransactionBalance_negativeQuantity_notOk() {
        fruit1.setQuantity(- 20);
        Assertions.assertThrows(RuntimeException.class, () -> balance.putTransaction(fruit1));
    }

    @Test
    void putTransactionPurchase_Ok() {
        storage.put("banana", 20);
        purchase.putTransaction(fruit4);
        Assertions.assertEquals(7, (int) storage.get("banana"));
    }

    @Test
    void putTransactionPurchase_notEnoughQuantity_notOk() {
        storage.put("banana", 0);
        Assertions.assertThrows(RuntimeException.class, () -> purchase.putTransaction(fruit4));
    }

    @Test
    void putTransactionPurchase_negativeQuantity_notOk() {
        fruit4.setQuantity(- 20);
        Assertions.assertThrows(RuntimeException.class, () -> purchase.putTransaction(fruit4));
    }

    @Test
    void putTransactionPurchase_fruitIsOut_notOk() {
        fruit4.setQuantity(20);
        Assertions.assertThrows(NoSuchElementException.class, () ->
                purchase.putTransaction(fruit4));
    }

    @Test
    void putTransactionReturn_Ok() {
        returnOp.putTransaction(fruit5);
        Assertions.assertTrue(storage.containsKey("banana")
                && storage.get("banana").equals(13));
    }

    @Test
    void putTransactionReturn_fruitExist_Ok() {
        storage.put("banana", 13);
        returnOp.putTransaction(fruit5);
        Assertions.assertEquals(26, (int) storage.get("banana"));
    }

    @Test
    void putTransactionReturn_negativeQuantity_notOk() {
        fruit5.setQuantity(- 1);
        Assertions.assertThrows(RuntimeException.class, () -> returnOp.putTransaction(fruit5));
    }

    @Test
    void putTransactionSupply_Ok() {
        supply.putTransaction(fruit3);
        Assertions.assertTrue(storage.containsKey("banana")
                && storage.get("banana").equals(100));
    }

    @Test
    void putTransactionSupply_fruitExist_Ok() {
        storage.put("banana", 100);
        supply.putTransaction(fruit3);
        Assertions.assertEquals(200, (int) storage.get("banana"));
    }

    @Test
    void putTransactionSupply_negativeQuantity_notOk() {
        fruit3.setQuantity(- 1);
        Assertions.assertThrows(RuntimeException.class, () -> supply.putTransaction(fruit3));
    }
}
