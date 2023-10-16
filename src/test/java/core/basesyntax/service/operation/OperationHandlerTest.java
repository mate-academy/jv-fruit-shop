package core.basesyntax.service.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class OperationHandlerTest {
    private OperationHandler operationHandler;

    @AfterEach
    void afterEach() {
        Storage.storage.clear();
    }

    @Test
    void balanceHandler_validData_ok() {
        operationHandler = new BalanceOperationHandlerImpl();
        FruitTransaction balanceTransaction1 =
                new FruitTransaction(FruitTransaction.Operation.BALANCE, "banana", 15);
        operationHandler.handle(balanceTransaction1);
        int exceptedBananaBalance = 15;
        int actualBananaBalance = Storage.storage.get("banana");
        assertEquals(exceptedBananaBalance, actualBananaBalance);
    }

    @Test
    void balanceHandler_transactionsIsNull_notOk() {
        operationHandler = new BalanceOperationHandlerImpl();
        FruitTransaction balanceTransactions = null;
        assertThrows(RuntimeException.class, () -> operationHandler.handle(balanceTransactions));
    }

    @Test
    void purchaseHandler_validData_ok() {
        operationHandler = new PurchaseOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction purchaseTransactions1 =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 10);
        operationHandler.handle(purchaseTransactions1);
        int exceptedBananaBalance = 10;
        int actualBananaBalance = Storage.storage.get("banana");
        assertEquals(exceptedBananaBalance,actualBananaBalance);
    }

    @Test
    void purchaseHandler_buyAll_ok() {
        operationHandler = new PurchaseOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 20);
        operationHandler.handle(fruitTransaction);
        int exceptedBalance = 0;
        int actualBalance = Storage.storage.get("banana");
        assertEquals(exceptedBalance, actualBalance);
    }

    @Test
    void purchaseHandler_buyNotValidQuantity_notOk() {
        operationHandler = new PurchaseOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 21);
        assertThrows(RuntimeException.class, () -> operationHandler.handle(fruitTransaction));
    }

    @Test
    void returnHandler_validData_Ok() {
        operationHandler = new ReturnOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 10);
        operationHandler.handle(fruitTransaction);
        int exceptedBalance = 30;
        int actualBalance = Storage.storage.get("banana");
        assertEquals(exceptedBalance, actualBalance);
    }

    @Test
    void returnHandler_notValidData_notOk() {
        operationHandler = new ReturnOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", -1);
        assertThrows(RuntimeException.class, () -> operationHandler.handle(fruitTransaction));
    }

    @Test
    void supplyHandler_validData_Ok() {
        operationHandler = new SupplyOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 10);
        operationHandler.handle(fruitTransaction);
        int exceptedBalance = 30;
        int actualBalance = Storage.storage.get("banana");
        assertEquals(exceptedBalance, actualBalance);
    }

    @Test
    void supplyHandler_notValidData_notOk() {
        operationHandler = new SupplyOperationHandlerImpl();
        Storage.storage.put("banana", 20);
        FruitTransaction fruitTransaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", -1);
        assertThrows(RuntimeException.class, () -> operationHandler.handle(fruitTransaction));
    }
}
