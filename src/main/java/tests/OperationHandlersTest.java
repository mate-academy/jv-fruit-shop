package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.PurchaseOperation;
import core.basesyntax.ReturnOperation;
import core.basesyntax.SupplyOperation;
import core.basesyntax.strategy.BalanceOperation;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OperationHandlersTest {

    @Test
    public void handle_balanceOperation_ok() {
        final OperationHandler handler = new BalanceOperation();
        final Map<String, Integer> storage = new HashMap<>();
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.BALANCE);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"),
                "Balance operation failed to set the correct quantity");
    }

    @Test
    public void handle_supplyOperation_ok() {
        final OperationHandler handler = new SupplyOperation();
        final Map<String, Integer> storage = new HashMap<>();
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.SUPPLY);
        transaction.setFruit("banana");
        transaction.setQuantity(100);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"),
                "Supply operation failed to add the correct quantity");
    }

    @Test
    public void handle_purchaseOperation_ok() {
        final OperationHandler handler = new PurchaseOperation();
        final Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 150);
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.PURCHASE);
        transaction.setFruit("banana");
        transaction.setQuantity(50);
        handler.handle(transaction, storage);

        assertEquals(100, (int) storage.get("banana"),
                "Purchase operation failed to subtract the correct quantity");
    }

    @Test
    public void handle_returnOperation_ok() {
        final OperationHandler handler = new ReturnOperation();
        final Map<String, Integer> storage = new HashMap<>();
        storage.put("banana", 50);
        final FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(Operation.RETURN);
        transaction.setFruit("banana");
        transaction.setQuantity(25);
        handler.handle(transaction, storage);

        assertEquals(75, (int) storage.get("banana"),
                "Return operation failed to add the correct quantity");
    }
}
