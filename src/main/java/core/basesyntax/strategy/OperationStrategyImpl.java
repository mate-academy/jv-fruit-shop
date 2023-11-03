package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operation.OperationHandlers;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandlers> typeHandlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandlers> typeHandlersMap) {
        this.typeHandlersMap = typeHandlersMap;
    }

    @Override
    public OperationHandlers getHandler(FruitTransaction.Operation operation) {
        return typeHandlersMap.get(operation);
    }

}
