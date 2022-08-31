package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class ApplyStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public ApplyStrategy(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    public void operationStrategy(FruitTransaction transaction) {
        OperationHandler operation = operations.get(transaction.getOperation());
        operation.apply(transaction);
    }
}
