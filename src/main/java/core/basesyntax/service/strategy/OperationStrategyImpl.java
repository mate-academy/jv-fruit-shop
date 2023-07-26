package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> map;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}
