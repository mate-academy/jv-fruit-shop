package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation activity) {
        return operations.get(activity);
    }
}
