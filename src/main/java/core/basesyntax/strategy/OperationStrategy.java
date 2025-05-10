package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public OperationStrategy(Map<FruitTransaction.Operation, OperationHandler>
                                     operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        return operationStrategies.get(operation);
    }
}
