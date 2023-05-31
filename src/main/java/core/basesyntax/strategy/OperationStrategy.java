package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> mapOfOperations;

    public OperationStrategy(Map<FruitTransaction.Operation, OperationHandler> mapOfOperations) {
        this.mapOfOperations = mapOfOperations;
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return mapOfOperations.get(operation);
    }
}
