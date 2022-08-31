package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operations;

    public OperationStrategy(Map<FruitTransaction.Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    public void process(FruitTransaction transaction) {
        OperationHandler operation = operations.get(transaction.getOperation());
        operation.apply(transaction);
    }
}
