package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.StorageDao;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap = new HashMap<>();
    private final StorageDao storageDao;

    public OperationStrategyImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
        fillMap();
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        if (!operationHandlerMap.containsKey(operation)) {
            throw new RuntimeException("Invalid operation submitted");
        }
        return operationHandlerMap.get(operation);
    }

    private void fillMap() {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(storageDao));
    }
}
