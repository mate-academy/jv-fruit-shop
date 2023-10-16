package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.Operation.OperationHandler;
import core.basesyntax.service.Operation.PurchaseOperationHandlerImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationStrategyTest {

    private OperationStrategyImpl operationStrategy;

    @BeforeEach
    public void setUp() {
        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap
                = new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl());
        operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);
    }

    @Test
    public void get_BalanceOperationHandler_ok() {
        OperationHandler handler = operationStrategy.get(FruitTransaction.Operation.BALANCE);
        assertTrue(handler instanceof BalanceOperationHandlerImpl);
    }

    @Test
    public void get_purchaseOperationHandler() {
        OperationHandler handler = operationStrategy.get(FruitTransaction.Operation.PURCHASE);
        assertTrue(handler instanceof PurchaseOperationHandlerImpl);
    }

    @Test
    public void testGet_NonExistentOperation() {
        OperationHandler handler = operationStrategy.get(null);
        assertNull(handler);
    }
}
