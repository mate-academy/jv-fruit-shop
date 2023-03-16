package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static Map<FruitTransaction.Operation, OperationHandler> operationHanlderMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler>
                                     operationHanlderMap) {
        this.operationHanlderMap = operationHanlderMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationHanlderMap.get(type);
    }
}
