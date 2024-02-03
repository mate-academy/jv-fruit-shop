package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.operation.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        OperationHandler operationHandler = operationHandlerMap.get(fruitTransaction.getOperation());
        operationHandler.handle(fruitTransaction);
    }
}
