package tests;

import core.basesyntax.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationHandlersTest {
    @Test
    public void testBalanceOperation() {
        OperationHandler handler = new BalanceOperation();
        Map<String, Integer> storage = new HashMap<>();
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        ((BalanceOperation) handler).handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testSupplyOperation() {
        OperationHandler handler = new SupplyOperation();
        Map<String, Integer> storage = new HashMap<>();
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.SUPPLY);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testPurchaseOperation() {
        OperationHandler handler = new PurchaseOperation();
        Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 150);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.PURCHASE);
        transaction.setFruit("banana");
        transaction.setQuantity(50);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"));
    }

    @Test
    public void testReturnOperation() {
        OperationHandler handler = new ReturnOperation();
        Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 50);
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.RETURN);
        transaction.setFruit("banana");
        transaction.setQuantity(25);
        handler.handle(transaction, storage);

        assertEquals(75, (int) storage.get("banana"));
    }
}
