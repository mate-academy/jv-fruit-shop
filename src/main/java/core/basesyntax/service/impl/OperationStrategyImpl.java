package core.basesyntax.service.impl;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitShopTransactions.Operation, OperationHandler> operationMap;

    public OperationStrategyImpl(Map<FruitShopTransactions.Operation,
            OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitShopTransactions.Operation operation) {
        return operationMap.get(operation);
    }
}
