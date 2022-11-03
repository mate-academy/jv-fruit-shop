package strategy;

import core.basesyntax.FruitTransaction;
import operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
