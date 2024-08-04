package tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.BalanceOperation;
import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.PurchaseOperation;
import core.basesyntax.ReturnOperation;
import core.basesyntax.SupplyOperation;

public class OperationHandlersTest {
    @Test
    public void testBalanceOperation() {
        final OperationHandler handler = new BalanceOperation();
        final Map<String, Integer> storage = new HashMap<>();
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testSupplyOperation() {
        final OperationHandler handler = new SupplyOperation();
        final Map<String, Integer> storage = new HashMap<>();
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.SUPPLY);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testPurchaseOperation() {
        final OperationHandler handler = new PurchaseOperation();
        final Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 150);
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.PURCHASE);
        transaction.setFruit("banana");
        transaction.setQuantity(50);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testReturnOperation() {
        final OperationHandler handler = new ReturnOperation();
        final Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 50);
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.RETURN);
        transaction.setFruit("banana");
        transaction.setQuantity(25);
        handler.handle(transaction, storage);

        assertEquals(75, (int) storage.get("banana"));
    }
}
