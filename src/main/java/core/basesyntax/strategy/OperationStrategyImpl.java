package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, Operation> operationHandler;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, Operation> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public Operation get(FruitTransaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
