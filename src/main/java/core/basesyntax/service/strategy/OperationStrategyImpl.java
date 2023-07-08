package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> fruitMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> fruitMap) {
        this.fruitMap = fruitMap;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return fruitMap.get(operation);
    }
}
