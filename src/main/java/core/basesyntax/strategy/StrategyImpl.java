package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitOperation.Operation, OperationHandler> fruitOperation;

    public StrategyImpl(Map<FruitOperation.Operation, OperationHandler> fruitOperation) {
        this.fruitOperation = fruitOperation;
    }

    @Override
    public OperationHandler get(FruitOperation.Operation operation) {
        return fruitOperation.get(operation);
    }
}
