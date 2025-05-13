package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;
import model.FruitTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OperationHandler;
import service.OperationStrategy;
import strategy.BalanceOperation;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

class OperationStrategyImplTest {
    private OperationStrategy operationStrategy;
    private final OperationHandler balanceOperation = new BalanceOperation();
    private final OperationHandler purchaseOperation = new PurchaseOperation();
    private final OperationHandler returnOperation = new ReturnOperation();
    private final OperationHandler supplyOperation = new SupplyOperation();

    @BeforeEach
    void setUp() {
        operationStrategy = new OperationStrategyImpl(Map.of(
                FruitTransaction.Operation.BALANCE, balanceOperation,
                FruitTransaction.Operation.PURCHASE, purchaseOperation,
                FruitTransaction.Operation.RETURN, returnOperation,
                FruitTransaction.Operation.SUPPLY, supplyOperation));
    }

    @Test
    void returnCorrectOperation_Ok() {
        assertEquals(balanceOperation, operationStrategy.get(FruitTransaction.Operation.BALANCE));
        assertEquals(purchaseOperation, operationStrategy.get(FruitTransaction.Operation.PURCHASE));
        assertEquals(returnOperation, operationStrategy.get(FruitTransaction.Operation.RETURN));
        assertEquals(returnOperation, operationStrategy.get(FruitTransaction.Operation.RETURN));
    }

    @Test
    void passOperationHandler_Null_notOk() {
        OperationStrategy emptyOperation = new OperationStrategyImpl(Map.of());
        assertNull(emptyOperation.get(FruitTransaction.Operation.BALANCE));
    }
}
