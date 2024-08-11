package tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

import core.basesyntax.Operation;
import core.basesyntax.OperationHandler;
import core.basesyntax.OperationStrategy;
import core.basesyntax.OperationStrategyImpl;
import core.basesyntax.PurchaseOperation;
import core.basesyntax.ReturnOperation;
import core.basesyntax.SupplyOperation;
import core.basesyntax.strategy.BalanceOperation;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OperationStrategyTest {

    private static OperationStrategy operationStrategy;

    @BeforeClass
    public void setUp() {
        Map<Operation, OperationHandler> operationHandlers = Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );
        operationStrategy = new OperationStrategyImpl(operationHandlers);
    }

    @Test
    public void getHandler_balanceOperation_ok() {
        OperationHandler handler = operationStrategy.getHandler(Operation.BALANCE);
        assertNotNull(handler, "Handler for BALANCE operation should not be null");
        assertTrue(handler instanceof BalanceOperation, "Handler should be instance of BalanceOperation");
    }

    @Test
    public void getHandler_purchaseOperation_ok() {
        OperationHandler handler = operationStrategy.getHandler(Operation.PURCHASE);
        assertNotNull(handler, "Handler for PURCHASE operation should not be null");
        assertTrue(handler instanceof PurchaseOperation, "Handler should be instance of PurchaseOperation");
    }

    @Test
    public void getHandler_returnOperation_ok() {
        OperationHandler handler = operationStrategy.getHandler(Operation.RETURN);
        assertNotNull(handler, "Handler for RETURN operation should not be null");
        assertTrue(handler instanceof ReturnOperation, "Handler should be instance of ReturnOperation");
    }

    @Test
    public void getHandler_supplyOperation_ok() {
        OperationHandler handler = operationStrategy.getHandler(Operation.SUPPLY);
        assertNotNull(handler, "Handler for SUPPLY operation should not be null");
        assertTrue(handler instanceof SupplyOperation, "Handler should be instance of SupplyOperation");
    }
}
