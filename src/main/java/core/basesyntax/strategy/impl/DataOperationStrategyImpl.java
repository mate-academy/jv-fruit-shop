package core.basesyntax.strategy.impl;

import core.basesyntax.db.operations.DataOperation;
import core.basesyntax.db.operations.BalanceOperationHandler;
import core.basesyntax.db.operations.PurchaseOperationHandler;
import core.basesyntax.db.operations.ReturnOperationHandler;
import core.basesyntax.db.operations.SupplyOperationHandler;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.DataOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class DataOperationStrategyImpl implements DataOperationStrategy {
    private final Map<Operation, DataOperation> operationDataMap;

    public DataOperationStrategyImpl(Map<Operation, DataOperation> operationDataMap) {
        this.operationDataMap = operationDataMap;
    }

    public DataOperationStrategyImpl() {
        operationDataMap = new HashMap<>();
        operationDataMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationDataMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationDataMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationDataMap.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public DataOperation get(Operation operation) {
        return operationDataMap.get(operation);
    }
}
