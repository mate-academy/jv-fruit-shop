package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.impl.OperationBalanceImpl;
import core.basesyntax.operations.impl.OperationPurchaseImpl;
import core.basesyntax.operations.impl.OperationReturnImpl;
import core.basesyntax.operations.impl.OperationSupplyImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, Operation> operationHandler = new HashMap<>();
    private StorageDao storage;

    public OperationStrategyImpl(StorageDao storage) {
        this.storage = storage;
        fillMap();
    }

    @Override
    public Operation get(FruitTransaction.Operation operation) {
        if (!operationHandler.containsKey(operation)) {
            throw new RuntimeException("Wrong operation ->" + operation);
        }
        return operationHandler.get(operation);
    }

    private void fillMap() {
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new OperationBalanceImpl(storage));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new OperationSupplyImpl(storage));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new OperationReturnImpl(storage));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchaseImpl(storage));
    }
}
