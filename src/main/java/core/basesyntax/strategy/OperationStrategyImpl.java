package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationConformity;
import core.basesyntax.service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final OperationConformity operationConformity;

    public OperationStrategyImpl() {
        operationConformity = new OperationConformity();
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationConformity.getHandlerByOperation(operation);
    }
}
