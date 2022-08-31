package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionHandle> operationHandler;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, TransactionHandle> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public TransactionHandle getByOperation(FruitTransaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
