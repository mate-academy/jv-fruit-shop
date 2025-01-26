package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperation;
import core.basesyntax.operation.SupplyOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationHandlersTest {
    private Map<String, Integer> storage;

    @BeforeEach
    void setUp() {
        storage = new HashMap<>();
    }

    @Test
    void testBalanceOperation() {
        OperationHandler handler = new BalanceOperation();
        FruitTransaction transaction = new FruitTransaction(
                FruitTransaction.Operation.BALANCE,
                "banana",
                20
        );

        handler.handle(storage, transaction);
        assertEquals(20, storage.get("banana").intValue());
    }

    @Test
    void testSupplyOperation() {
        OperationHandler handler = new SupplyOperation();

        // Initial supply
        handler.handle(storage, new FruitTransaction(
                FruitTransaction.Operation.SUPPLY,
                "apple",
                100
        ));
        assertEquals(100, storage.get("apple").intValue());

        // Additional supply
        handler.handle(storage, new FruitTransaction(
                FruitTransaction.Operation.SUPPLY,
                "apple",
                50
        ));
        assertEquals(150, storage.get("apple").intValue());
    }

    @Test
    void testPurchaseOperation() {
        storage.put("banana", 100);
        OperationHandler handler = new PurchaseOperation();

        handler.handle(storage, new FruitTransaction(
                FruitTransaction.Operation.PURCHASE,
                "banana",
                30
        ));
        assertEquals(70, storage.get("banana").intValue());
    }

    @Test
    void testPurchaseOperationInsufficientStock() {
        storage.put("banana", 20);
        OperationHandler handler = new PurchaseOperation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> handler.handle(storage, new FruitTransaction(
                        FruitTransaction.Operation.PURCHASE,
                        "banana",
                        30
                )));

        assertEquals("Not enough banana in storage", exception.getMessage());
    }
}
