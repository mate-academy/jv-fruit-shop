package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationStrategyImplTest {
    private final StorageDao storageDao = new StorageDaoImpl();
    private final HashMap<FruitTransaction.Operation, OperationHandler> operationHashMap
            = new HashMap<>();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl(operationHashMap);
    private final BalanceHandler balanceHandler = new BalanceHandler(storageDao);
    private final PurchaseHandler purchaseHandler = new PurchaseHandler(storageDao);
    private final ReturnHandler returnHandler = new ReturnHandler(storageDao);
    private final SupplyHandler supplyHandler = new SupplyHandler(storageDao);
    private final FruitTransaction fruitTransaction = new FruitTransaction();

    @BeforeEach
    public void beforeEachTest() {
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        operationHashMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
    }

    @Test
    void getBalanceHandler_Ok() {
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        String actual = String.valueOf(operationStrategy.get(fruitTransaction
                        .getOperation())
                .getClass());
        String expected = String.valueOf(balanceHandler.getClass());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPurchaseHandler_Ok() {
        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
        String actual = String.valueOf(operationStrategy.get(fruitTransaction
                        .getOperation())
                .getClass());
        String expected = String.valueOf(purchaseHandler.getClass());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void detReturnHandler_Ok() {
        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
        String actual = String.valueOf(operationStrategy.get(fruitTransaction
                .getOperation()).getClass());
        String expected = String.valueOf(returnHandler.getClass());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getSupplyHandler_Ok() {
        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
        String actual = String.valueOf(operationStrategy.get(fruitTransaction
                .getOperation()).getClass());
        String expected = String.valueOf(supplyHandler.getClass());
        Assertions.assertEquals(expected, actual);
    }
}
