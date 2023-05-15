package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PlusOperationHandler;
import core.basesyntax.strategy.operation.SubtractOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    {
        operationHandlerMap = new HashMap<>();
        init_strategy_map();
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation code) {
        return operationHandlerMap.get(code);
    }

    private void init_strategy_map() {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new PlusOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new PlusOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new PlusOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new SubtractOperationHandler());
    }

}
