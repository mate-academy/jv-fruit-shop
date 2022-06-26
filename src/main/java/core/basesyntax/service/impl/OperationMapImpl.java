package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.OperationMap;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationMapImpl implements OperationMap {
    private final Map<FruitShopTransactions.Operation, OperationHandler> operationMap;

    public OperationMapImpl(Map<FruitShopTransactions.Operation,
            OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(FruitShopTransactions.Operation operation) {
        return operationMap.get(operation);
    }
}
