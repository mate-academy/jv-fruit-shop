package core.basesyntax.strategy;

import core.basesyntax.operation.OperationHandler;
import core.basesyntax.transaction.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
